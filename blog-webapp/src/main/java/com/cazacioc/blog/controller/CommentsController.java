package com.cazacioc.blog.controller;

import com.cazacioc.blog.entity.Comment;
import com.cazacioc.blog.service.CommentService;
import com.cazacioc.blog.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/entry/{entryid}/comment")
public class CommentsController {
    @Autowired
    private EntryService entryService;

    @Autowired
    private CommentService commentService;


    @RequestMapping(value = "/{commentid}/delete", method = RequestMethod.GET)
    public String deleteComment(ModelMap model, @PathVariable("entryid") Long entryId, @PathVariable("commentid") Long commentId) {
        commentService.removeCommentByEntryIdAndCommentId(commentId, entryId);
        return "redirect:/blog/entry/" + entryId;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addComment(ModelMap model, @PathVariable("entryid") Long entryId) {
        if (entryService.getEntryById(entryId) == null) {
            return "redirect:/blog/";
        }

        model.addAttribute("comment", new Comment());
        return "comment-add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult bindingResult, @PathVariable("entryid") Long entryId) {
        if (entryService.getEntryById(entryId) == null) {
            return "redirect:/blog/";
        }

        if (bindingResult.hasErrors()) {
            return "comment-add";
        }

        commentService.addCommentByEntryId(comment, entryId);

        return "redirect:/blog/entry/" + entryId;
    }
}
