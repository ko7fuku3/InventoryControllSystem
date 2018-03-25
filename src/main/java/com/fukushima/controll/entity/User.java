package com.fukushima.controll.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ユーザーのentity
 * @author koshiro
 *
 */
@Entity
@Table(name="user")
public class User implements Serializable{

	private static final long serialVersionUID = -7141462005973422285L;

	@Id
	@Column(name="id")
	private int id;

	@Column(name="user_name")
	private String userName;

	@Column(name="password")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
