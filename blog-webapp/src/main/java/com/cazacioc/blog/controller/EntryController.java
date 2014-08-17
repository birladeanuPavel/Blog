package com.cazacioc.blog.controller;

import com.cazacioc.blog.entity.Entry;
import com.cazacioc.blog.service.CommentService;
import com.cazacioc.blog.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.ParseState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/{id}")
    public String hello(ModelMap model, @PathVariable("id") Long id) {
        Entry entry = entryService.getEntryById(id);
        if (entry == null) {
            return "redirect:/blog/";
        }

        model.addAttribute("entry", entry);
        model.addAttribute("comments", commentService.getCommentsForEntry(entry));
        return "entry";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteNews(@PathVariable("id") Long id) {
        entryService.removeEntryById(id);
        return "redirect:/blog/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNews(ModelMap model) {
        model.addAttribute("entry", new Entry());
        return "entry-add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveNews(@Valid @ModelAttribute("entry") Entry entry, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "entry-add";
        }

        entry.setDate(new Date());
        entryService.addEntry(entry);

        return "redirect:/blog/";
    }
}
