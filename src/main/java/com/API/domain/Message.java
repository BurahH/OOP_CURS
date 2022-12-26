package com.API.domain;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String message;

    private String author;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "user_id")
    private User user;

    public Message() {
    }

    public Message(String message, User user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
