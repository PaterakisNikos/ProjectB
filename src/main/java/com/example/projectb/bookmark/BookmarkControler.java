package com.example.projectb.bookmark;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookmarkControler {
	
	@Autowired
	private BookmarkService bookmarkService;
	
	@RequestMapping("/bookmarks")
	public List<Bookmark> GetBookmarks(){
		return bookmarkService.GetBookMarks();
	}
	

}
