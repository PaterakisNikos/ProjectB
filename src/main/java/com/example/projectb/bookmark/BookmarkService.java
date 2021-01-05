package com.example.projectb.bookmark;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {

	@Autowired
	private BookmarkRepository bookmarkRepo;
	
	public List<Bookmark> GetBookMarks() {
		List<Bookmark> data =new ArrayList<>();
		Iterable<Bookmark> iterable= bookmarkRepo.findAll();
		for(Bookmark bm:iterable) data.add(bm);
		return data;
	}
	
	
	
}
