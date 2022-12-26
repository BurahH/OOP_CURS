package com.API.domain;

import javax.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Phone(String number, User user) {
        this.number = number;
        this.user = user;
    }

    public Phone() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
