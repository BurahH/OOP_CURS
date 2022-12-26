package com.API.domain;

import javax.persistence.*;

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int priceOne;
    private int priceTwo;
    private int priceThree;

    public Price(int priceOne, int priceTwo, int priceThree) {
        this.priceOne = priceOne;
        this.priceTwo = priceTwo;
        this.priceThree = priceThree;
    }

    public Price() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPriceOne() {
        return priceOne;
    }

    public void setPriceOne(int priceOne) {
        this.priceOne = priceOne;
    }

    public int getPriceTwo() {
        return priceTwo;
    }

    public void setPriceTwo(int priceTwo) {
        this.priceTwo = priceTwo;
    }

    public int getPriceThree() {
        return priceThree;
    }

    public void setPriceThree(int priceThree) {
        this.priceThree = priceThree;
    }
}
