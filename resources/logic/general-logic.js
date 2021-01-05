
var ASYNC_REQUEST = function(type, url, data, callback)
{
	type = type.toLowerCase();
	let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function()
  {
    if(this.readyState == 4 & this.status == 200){//We got a "correct" Response
      let response=JSON.parse(this.responseText);
      callback(response);
    }
  };
	xhttp.open(type, url, true);
  if(type!='get'){
		xhttp.setRequestHeader('Content-Type', 'application/json');
		xhttp.send(JSON.stringify(data));	
  }
	else xhttp.send();
};

var API_KEY = '16f03bc9';


