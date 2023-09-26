package com.java.model;


public class Good {
    private int id;
    private String name;
    private String made;
    private String created;
    private String model;
    private int purchasePrice;
    private int retailPrice;
    private int quantity;

    public Good() {
    }

    public Good( String name, String made, String created, String model, int purchasePrice, int retailPrice, int quantity) {
        this.name = name;
        this.made = made;
        this.created = created;
        this.model = model;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
        this.quantity = quantity;
    }

    public Good(int id, String number, String name, String made, String created, String model, int purchasePrice, int retailPrice, int quantity) {
        this.id = id;
        this.name = name;
        this.made = made;
        this.created = created;
        this.model = model;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
        this.quantity = quantity;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
