package com.cazacioc.blog.dto;

import com.cazacioc.blog.entity.Entry;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by scorpion on 13.08.14.
 */
public class CommentDTO {

    private Long id;

    private Date date;

    @NotNull
    @Size(min = 20, max = 1000)
    private String content;

    private Entry entry;
}
