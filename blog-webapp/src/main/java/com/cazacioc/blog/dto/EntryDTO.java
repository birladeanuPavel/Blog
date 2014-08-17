package com.cazacioc.blog.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by scorpion on 13.08.14.
 */
public class EntryDTO {

    private Long id;

    private Date date;

    @NotNull
    @Size(min = 10)
    private String title;

    private String content;

}
