package com.hihihigh.crm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author victor
 *
 */
public class MyUserDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private List<MyAuthorities> authorities = new ArrayList<>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<MyAuthorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<MyAuthorities> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", authorities=" + authorities + "]";
	}
	
}
