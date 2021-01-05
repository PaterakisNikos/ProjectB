package com.example.projectb.associations;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AccountBookmarkRepository extends CrudRepository<AccountBookmark, String> {
	
	List<AccountBookmark> findByAccID(long accID);
	List<AccountBookmark> findByImdbID(String imdbID);

}
