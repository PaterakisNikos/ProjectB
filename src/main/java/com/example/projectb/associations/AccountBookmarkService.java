package com.example.projectb.associations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectb.account.AccountRepository;
import com.example.projectb.account.Account;
import com.example.projectb.bookmark.BookmarkRepository;
import com.example.projectb.bookmark.Bookmark;

@Service
public class AccountBookmarkService {

	@Autowired
	private AccountBookmarkRepository acc_bm_repo;

	@Autowired
	private AccountRepository acc_repo;
	
	@Autowired
	private BookmarkRepository bm_repo;
	
	
	public List<String> FindLinks(long accID){
		List<String> data = new ArrayList<>();
		List<AccountBookmark> rows = acc_bm_repo.findByAccID(accID);
		for(AccountBookmark row:rows)
			data.add(row.getImdbID());
		return data;
	}
	
	public List<Long> FindLinks(String imdbID){
		List<Long> data = new ArrayList<>();
		List<AccountBookmark> rows = acc_bm_repo.findByImdbID(imdbID);
		for(AccountBookmark row:rows)
			data.add(row.getAccID());
		return data;
	}
	
	public boolean Link(long accID, String imdbID) {
		Optional<Account> acc = acc_repo.findById(accID);
		if(!acc.isPresent())return false;//No such user exist
		Optional<Bookmark> bm = bm_repo.findById(imdbID);
		if(!bm.isPresent()) bm_repo.save(new Bookmark(imdbID));
		acc_bm_repo.save(new AccountBookmark(accID, imdbID));
		return true;
	}
	
	
	public boolean Unlink(long accID, String imdbID) {
		String ID=accID+imdbID;
		if(!acc_bm_repo.existsById(ID))return false;
		acc_bm_repo.deleteById(ID);
		return true;
	}
	
}
