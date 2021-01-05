package com.example.projectb.bookmark;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bookmark {
	
	@Id
	private String ID;
	
	public Bookmark(String ID){
		super();
		this.ID= ID;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	public Bookmark(){super();}
	
}
