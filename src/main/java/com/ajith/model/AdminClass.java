package com.ajith.model;

import java.util.Objects;

public class AdminClass {
	private int id;
	private String name;
	private String email;
	private long mobileNo;
	private String password;
	public AdminClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AdminClass(int id, String name, String email, long mobileNo, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "\n name=" + name + ", \n email=" + email + ", \n mobileNo=" + mobileNo + ", \n password=" + password
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminClass other = (AdminClass) obj;
		return Objects.equals(email, other.email);
	}
	
	
	

}
