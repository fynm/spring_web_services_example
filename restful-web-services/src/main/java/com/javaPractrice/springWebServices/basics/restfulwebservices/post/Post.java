package com.javaPractrice.springWebServices.basics.restfulwebservices.post;

import java.util.Date;

public class Post {
    private Integer id;
    private String content;
    private Date date;
    private Integer userId;

    public Post(){}

    public Post(Integer id, String content, Date date, Integer userId) {
        super();
        this.id = id;
        this.content = content;
        this.date = date;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Post [content=" + content + ", date=" + date + ", id=" + id + ", userId=" + userId + "]";
    }
}