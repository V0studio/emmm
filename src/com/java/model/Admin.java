package com.java.model;

public class Admin {
	private int id;
	private String account;
	private String password;
	private String phone;
	private String name;

	public Admin() {
	}

	public Admin(int id, String account, String password, String phone) {
		this.id = id;
		this.account = account;
		this.password = password;
		this.phone = phone;
	}

	public Admin(String account, String password, String phone, String name) {
		this.account = account;
		this.password = password;
		this.phone = phone;
		this.name = name;
	}

	public Admin(String account, String password) {
		this.account = account;
		this.password = password;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
}
