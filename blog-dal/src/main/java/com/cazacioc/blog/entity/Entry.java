package com.cazacioc.blog.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by scorpion on 09.08.14.
 */
@Entity
@Table(name = "ENTRIES")
public class Entry implements Serializable {

    private static final long serialVersionUID = 1725971943151314847L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Lob
    @Column(name = "CONTENT", columnDefinition = "CLOB(64K)")
    private String content;

    @OneToMany(mappedBy = "entry", fetch = FetchType.LAZY)
    private Set<Comment> comments = new HashSet<Comment>();

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
