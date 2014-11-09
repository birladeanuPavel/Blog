package com.cazacioc.blog.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by scorpion on 09.08.14.
 */
@Entity
@Table(name = "COMMENTS")
public class Comment implements Serializable {

    private static final long serialVersionUID = -2257725438881609058L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Lob
    @Column(name = "CONTENT", columnDefinition = "CLOB(1K)")
    private String content;

    @ManyToOne
    @JoinColumn(name = "ENTRY_ID")
    private Entry entry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    
    // comment
}

