package com.example.projectb.associations;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountBookmark {
	
	@Id
	private String linkID;
	
	private long accID;
	
	private String imdbID;
	
	AccountBookmark(long accID, String imdbID){
		super();
		this.accID = accID;
		this.imdbID = imdbID;
		linkID = this.accID + imdbID; 
	}
	
	public String getID() {
		return linkID;
	}
	public long getAccID() {
		return accID;
	}
	public String getImdbID() {
		return imdbID;
	}
	
	AccountBookmark(){super();}
	
}
