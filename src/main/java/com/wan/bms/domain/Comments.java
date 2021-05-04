package com.wan.bms.domain;

import java.util.Date;

public class Comments {
    private Long id;

    /**
    * 评论书籍id
    */
    private Long bookId;

    /**
    * 评论者username
    */
    private String username;

    /**
    * 评论内容
    */
    private String comments;

    /**
    * 评论日期
    */
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookid() {
        return bookId;
    }

    public void setBookid(Long bookid) {
        this.bookId = bookid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}