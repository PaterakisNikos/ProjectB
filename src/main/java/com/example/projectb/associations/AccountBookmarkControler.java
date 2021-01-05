package com.example.projectb.associations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectb.BookmarkData;


@RestController
public class AccountBookmarkControler {

	@Autowired
	private AccountBookmarkService acc_bm_service;
	
	@RequestMapping(method=RequestMethod.PUT, value="/bookmarks")
	public boolean AddBookMark(@RequestBody BookmarkData data) {
		return acc_bm_service.Link(data.accID, data.bookmarkID);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/bookmarks")
	public boolean DeleteBookMark(@RequestBody BookmarkData data) {
		return acc_bm_service.Unlink(data.accID, data.bookmarkID);
	}
	
	
	@RequestMapping("/accbookmarks")
	public List<String> GetBookmakrs(@RequestParam long accID){
		return acc_bm_service.FindLinks(accID);
	}
	
}
