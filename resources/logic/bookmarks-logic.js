var space = null;
var timer = null;
var galleryElement = null;
var accID = 0;
var bookmarks = [];

//When the page loads
window.onload = function()
{
	accID = window.location.href.toString().split('?accID=')[1];
	getBookmarkIDs(accID);
	
    space = document.getElementById('space');

    galleryElement = document.createElement('div');
    let attrib = document.createAttribute('class');
    attrib.value = 'gallery';
    let imgElement = document.createElement('img');
    galleryElement.setAttributeNode(attrib);
    galleryElement.appendChild(imgElement);
}


function retrieveBookmarks(){
    for(var i=0;i<bookmarks.length;i++){
    	let url = 'http://www.omdbapi.com/?apikey='+API_KEY+'&type=movie&i='+bookmarks[i];
    	ASYNC_REQUEST('get', url, null, loadResult);
    }
}


function loadResult(result){
    var newItem=galleryElement.cloneNode(true);
    newItem.childNodes[0].src = result['Poster'];
    newItem.addEventListener('click', function(event)
    {
    	event.preventDefault();
    	let location = window.location.href.substr(0, window.location.href.indexOf('/'));
    	window.location.replace(location+'movies?imdbID='+result['imdbID']+'&accID='+accID);
    });
    space.appendChild(newItem);
}

function getBookmarkIDs(accID){
	let url = '../accbookmarks?accID='+accID;
	ASYNC_REQUEST('get', url, null, function(data){bookmarks=data; retrieveBookmarks();});
}

//mybookmarks?accID=1/..
function redirectMovies(){ 
	let location = window.location.href.substr(0, window.location.href.indexOf('/'));
	window.location.replace(location+'movies?accID='+accID);
}
