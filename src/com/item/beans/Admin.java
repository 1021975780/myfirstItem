package com.item.beans;
/**
 * 管理员类
 * @author wangqun
 *
 */
public class Admin {
	private int id;
	private String email;
	private String pwd;
	private String image;
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
	public Admin(int id, String email, String pwd, String image) {
		super();
		this.id = id;
		this.email = email;
		this.pwd = pwd;
		this.image = image;
	}
	public Admin(String email, String pwd, String image) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.image = image;
	}
	public Admin(String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", email=" + email + ", pwd=" + pwd + ", image=" + image + "]";
	}
	public Admin() {
		super();
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
