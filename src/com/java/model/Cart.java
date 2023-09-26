package com.java.model;


public class Cart {
    private int id;
    private int goodNumber;
    private String userName;
    private int userId;
    private String created;
    private int totalPrice;
    private int price;
    private int goodQuantity;

    public Cart() {
    }

    public Cart(int id, int goodNumber, String userName, int user_id, String created, int totalPrice, int price, int goodQuantity) {
        this.id = id;
        this.goodNumber = goodNumber;
        this.userName = userName;
        this.userId = userId;
        this.created = created;
        this.totalPrice = totalPrice;
        this.price = price;
        this.goodQuantity = goodQuantity;
    }

    public Cart(int goodNumber, String userName, int user_id, String created, int totalPrice, int price, int goodQuantity) {
        this.goodNumber = goodNumber;
        this.userName = userName;
        this.userId = user_id;
        this.created = created;
        this.totalPrice = totalPrice;
        this.price = price;
        this.goodQuantity = goodQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(int goodNumber) {
        this.goodNumber = goodNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGoodQuantity() {
        return goodQuantity;
    }

    public void setGoodQuantity(int goodQuantity) {
        this.goodQuantity = goodQuantity;
    }
}
