var description = null;
var metadata = null;
var poster = null;
var searchbar = null;
var searchform = null;
var bookmark=null;
var bmflag = false;//TODO: 
var timer = null;
var bookmarks = [];
var doneTypingInterval = 1500;
var accID = 0;
var currentMovie = null;

/**
 * For detecting the stop typing we use the same logic as described here: https://stackoverflow.com/questions/4220126/run-javascript-function-when-user-finishes-typing-instead-of-on-key-up
 * Without using jquery just plain javascript
 */
function onKeyUp(){
    clearTimeout(timer);
    timer = setTimeout(search, doneTypingInterval, searchbar.value);
}

function onKeyDown(){
    clearTimeout(timer);
}

//When the page loads
window.onload = function()
{
	accID = window.location.href.toString().split('accID=')[1];
	getBookmarkIDs(accID);
	
	if(window.location.href.includes('?imdbID=')){
		currentMovie = (window.location.href.split('?imdbID=')[1]).split('&')[0];
		let url = 'http://www.omdbapi.com/?apikey='+API_KEY+'&type=movie&i='+currentMovie;
		ASYNC_REQUEST('get', url, null, ReloadResult);//TODO: setTimeout
	}
	
	description = document.getElementById('description');
    poster = document.getElementById('poster');
    searchbar = document.getElementById('searchbar');
    searchform = document.getElementById('searchform');
    metadata = document.getElementById('metadata');
    bookmark = document.getElementById('bookmark');
    
    bookmark.addEventListener('click', UpdateBookmark);
    searchform.addEventListener('submit', function(event){event.preventDefault();});
    searchbar.onkeyup = onKeyUp;
    searchbar.onkeydown = onKeyDown;
}



/**
 * Search movie request with help of: omdbapi
 * @see general-logic.js
 * @param {string} title  Title of the movie we are searching for
 */
function search(title){
    let url = 'http://www.omdbapi.com/?apikey='+API_KEY+'&type=movie&t='+title;
	ASYNC_REQUEST('get', url, null, ReloadResult);
}


function ReloadResult(result){
	console.log(bookmarks);
    if(result['Response']=='False') {console.log(result['Error']); return;}
    poster.src=result['Poster'];
    let metdata = result['Rated']+'\t|\t'+result['Runtime']+'\t|\t'+result['Genre']+'\t|\t'+result['Released'];
    currentMovie = result['imdbID'];
    if(bookmarks.includes(currentMovie)){
    	bookmark.src='../images/fillStar.png';
    	bmflag = true;
    }
    else{
    	bookmark.src='../images/emptyStar.png';
    	bmflag = false;
    }
    metadata.innerText = metdata;
    description.innerText = result['Plot'];
}

function UpdateBookmark(event){
	event.preventDefault();
	let data = {"accID": parseInt(accID), "bookmarkID": currentMovie};
	let url = '../bookmarks';
	if(bmflag) ASYNC_REQUEST('delete', url, data, function(data){bookmark.src='../images/fillStar.png';});
	else ASYNC_REQUEST('put', url, data, function(data){bookmark.src='../images/emptyStar.png';});
}


function getBookmarkIDs(accID){
	let url = '../accbookmarks?accID='+accID;
	ASYNC_REQUEST('get', url, null, function(data){bookmarks=data;});
}

//mybookmarks?accID=1/..
function redirectMyBookmarks(){ 
	let location = window.location.href.substr(0, window.location.href.indexOf('/'));
	window.location.replace(location+'mybookmarks?accID='+accID);
}
