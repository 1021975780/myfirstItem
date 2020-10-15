package com.item.beans;
/**
 * ”√ªß¿‡
 * @author wangqun
 *
 */
public class User {
	private int id;
	private String phone;
	private String pwd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public User(int id, String phone, String pwd) {
		super();
		this.id = id;
		this.phone = phone;
		this.pwd = pwd;
	}

	public User(String phone, String pwd) {
		super();
		this.phone = phone;
		this.pwd = pwd;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", phone=" + phone + ", pwd=" + pwd + "]";
	}

}
