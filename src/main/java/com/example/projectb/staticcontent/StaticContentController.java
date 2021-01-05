package com.example.projectb.staticcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticContentController {
	
	@Autowired
	private StaticContentService staticContentService;
	
	
	//-----Pages-----
	@RequestMapping("/")
	public String GetHomePage() {
		return staticContentService.getLogPage();
	}
	
	@RequestMapping("/movies")
	public String GetMoviePage() { return staticContentService.getMoviesPage();}
	
	@RequestMapping("/mybookmarks")
	public String GetBookmarksPage() { return staticContentService.getBookmarksPage();}
	
	//-----Styles-----
	@RequestMapping("/style/log-style.css")
	public String GetStyle() {
		return staticContentService.getLogStyle();
	}
	
	@RequestMapping("/style/movies-style.css")
	public String GetMovieStyle() {return staticContentService.getMoviesStyle();}
	
	@RequestMapping("/style/bookmarks-style.css")
	public String GetBoookmarksStyle() {return staticContentService.getBookmarksStyle();}
	
	//-----Scripts-----	
	@RequestMapping("/scripts/general-logic.js")
	public String GetLogic() {
		return staticContentService.getGeneralLogic();
	}
	
	@RequestMapping("/scripts/log-logic.js")
	public String GetLogLogic() {
		return staticContentService.getLogLogic();
	}
	
	@RequestMapping("/scripts/movies-logic.js")
	public String GetMovieLogic() {return staticContentService.getMovieLogic();}
	
	@RequestMapping("/scripts/bookmarks-logic.js")
	public String GetBookmarksLogic() {return staticContentService.getBookmarksLogic();}
	
	//-----Images-----
	@RequestMapping("/images/Logo.png")
	public byte[] GetLogo() {
		return staticContentService.getLogo();
	}

	@RequestMapping("/images/user.png")
	public byte[] GetUserIcon() {
		return staticContentService.getUserImage();
	}
	
	@RequestMapping("/images/emptyStar.png")
	public byte[] GetEmptyStarIcon() {
		return staticContentService.getEmptyStar();
	}

	@RequestMapping("/images/fillStar.png")
	public byte[] GetStarIcon() {
		return staticContentService.getStar();
	}
}
