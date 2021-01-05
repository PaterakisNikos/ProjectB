package com.example.projectb.staticcontent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;

@Service
public class StaticContentService {
	

	//----HTMLS
	private String loghtml = new String(readAllBytesJava7("resources/pages/log.html"));
	private String movieshtml = new String(readAllBytesJava7("resources/pages/movies.html"));
	private String bookmarkshtml = new String(readAllBytesJava7("resources/pages/bookmarks.html"));

	//CSS
	private String logcss = new String(readAllBytesJava7("resources/styles/log-style.css"));
	private String moviescss = new String(readAllBytesJava7("resources/styles/movies-style.css"));
	private String bookmarkscss = new String(readAllBytesJava7("resources/styles/bookmarks-style.css"));

	//JS
	private String generaljs = new String(readAllBytesJava7("resources/logic/general-logic.js"));
	private String logjs = new String(readAllBytesJava7("resources/logic/log-logic.js"));
	private String moviejs = new String(readAllBytesJava7("resources/logic/movies-logic.js"));
	private String bookmarksjs = new String(readAllBytesJava7("resources/logic/bookmarks-logic.js"));
	
	//Images
	private byte [] logoImage = readAllBytesJava7("resources/images/Logo.png");
	private byte [] userImage = readAllBytesJava7("resources/images/user.png");
	private byte [] notBookmarked = readAllBytesJava7("resources/images/emptyStar.png");
	private byte [] bookmarked = readAllBytesJava7("resources/images/fillStar.png");
	
	public String getBookmarksPage() { return bookmarkshtml; }
	public String getBookmarksStyle() { return bookmarkscss; }
	public String getBookmarksLogic() { return bookmarksjs; }
	
	public String getGeneralLogic() {return generaljs;}
	
	public String getMoviesPage() {
		return movieshtml;
	}

	public byte[] getEmptyStar() {
		return notBookmarked;
	}

	public byte[] getStar() {
		return bookmarked;
	}

	public String getMoviesStyle() {
		return moviescss;
	}

	public String getMovieLogic() {
		return moviejs;
	}

	public String getLogLogic() {
		return logjs;
	}

	public String getLogStyle() {
		return logcss;
	}

	public String getLogPage() {
		return loghtml;
	}

	
	public byte[] getLogo() {return logoImage;}
	
	public byte[] getUserImage() {return userImage;}
	
	
	
	private static byte[] readAllBytesJava7(String filePath) 
	{
	    byte[] data=null;
	    try
	    {
	        data = Files.readAllBytes( Paths.get(filePath) ) ;
	    } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	    return data;
	}

	
}
