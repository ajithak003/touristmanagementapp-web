package com.touristmgntapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class UserClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String email;
	private long mboNo;
	private String password;
	private long wallet;
	private LocalDateTime registerDate;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getWallet() {
		return wallet;
	}

	public UserClass(int id, String name, String email, long mboNo, String password, long wallet,
			LocalDateTime registerDate,String status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mboNo = mboNo;
		this.password = password;
		this.wallet = wallet;
		this.registerDate = registerDate;
		this.status = status;
	}

	public LocalDateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}

	public void setWallet(long wallet) {
		this.wallet = wallet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserClass(int id, String name, String email, long mboNo, String password, long wallet) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mboNo = mboNo;
		this.password = password;
		this.wallet = wallet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMboNo() {
		return mboNo;
	}

	public void setMboNo(long mboNo) {
		this.mboNo = mboNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User : \n name=" + name + ", \n email=" + email + ",\n mobile no=" + mboNo + ",\n password=" + password
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
		UserClass other = (UserClass) obj;
		return Objects.equals(email, other.email);
	}

	public UserClass() {
		super();
	}

	public UserClass(String name, String email, long mboNo, String password) {
		super();
		this.name = name;
		this.email = email;
		this.mboNo = mboNo;
		this.password = password;
	}

	public UserClass(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public UserClass(String email) {
		super();
		this.email = email;
	}

	public UserClass(long wallet) {
		super();
		this.wallet = wallet;
	}

}