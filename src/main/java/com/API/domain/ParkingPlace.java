package com.API.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ParkingPlace implements Comparable<ParkingPlace>{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long number;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "price_id")
    private Price price;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "user_id")
    private User user;

    public ParkingPlace(Long number, Price price) {
        this.number = number;
        this.price = price;
    }

    public ParkingPlace() {
    }

    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean haveUser(){
        if(this.user == null){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean checkEndTime(){
        if(this.endDate == null){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public int compareTo(ParkingPlace o) {
        return number.compareTo(o.number);
    }
}
