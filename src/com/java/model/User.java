package com.java.model;


public class User {
    private int id;
    private String account;
    private String password;
    private String name;
    private String level;
    private String created;
    private int total;
    private String phone;
    private String email;

    public User() {
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public User(int id, String account, String password, String name, String level, String created, int total, String phone, String email) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.level = level;
        this.created = created;
        this.total = total;
        this.phone = phone;
        this.email = email;
    }

    public User(String account, String password, String name, String level, String created, int total, String phone, String email) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.level = level;
        this.created = created;
        this.total = total;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
