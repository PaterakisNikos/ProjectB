package com.example.projectb.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ID;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	

	Account(String email, String pass){
		super();
		this.email = email;
		password = pass;
	}
	
	public long getID() {return ID;}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
	Account(){super();}
	
}
