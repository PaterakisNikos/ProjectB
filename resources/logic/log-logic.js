var login = true;
var logform = null;
var email = null;
var pass = null;
var promptv = null;
var changetrigger = null;
var logbutton = null;
var elements= [];

var bigsize = '500px';
var smallsize = '420px'; 

window.onload = function()
{
    logform = document.getElementById('logform');
    logform.addEventListener('submit', commit);
    promptv = document.getElementById('prompt');
    changetrigger = document.getElementById('changetrigger');
    logbutton = document.getElementById('logbutton');
    
    email = document.getElementById('email');
    pass = document.getElementById('pass');

    var textElement = document.createElement('a');
    textElement.innerText = 'Confirm Password';

    var inputElement = document.createElement('input');
    var inputID = document.createAttribute('id');
    inputID.value  = 'cpass';
    var inputPlaceholder = document.createAttribute('placeholder');
    inputPlaceholder.value = 'Enter your password again';
    var inputType = document.createAttribute('type');
    inputType.value = 'password';
    inputElement.setAttributeNode(inputID);
    inputElement.setAttributeNode(inputPlaceholder);
    inputElement.setAttributeNode(inputType);


    elements.push(textElement);
    elements.push(inputElement);
};


function change(){
    login=!login;
    let root =  document.documentElement;
    if(!login){
        logform.insertBefore(elements[0], logform.childNodes[logform.childNodes.length - 5]);
        logform.insertBefore(elements[1], logform.childNodes[logform.childNodes.length - 5]);
        logform.insertBefore(document.createElement('br'), logform.childNodes[logform.childNodes.length - 5]);
        root.style.setProperty("--logbox-height", bigsize);
        promptv.innerText = 'Sign Up';
        changetrigger.innerText = 'Already have an account?'
        logbutton.value = 'Create Account';
    }
    else{
        logform.removeChild(logform.childNodes[logform.childNodes.length-6]);
        logform.removeChild(logform.childNodes[logform.childNodes.length-6]);
        logform.removeChild(logform.childNodes[logform.childNodes.length-6]);
        root.style.setProperty("--logbox-height", smallsize);
        promptv.innerText = 'Sign In';
        changetrigger.innerText = 'Don\'t have an account?';
        logbutton.value = 'Login';
    }
}

function commit(event){
	event.preventDefault();
	let url = 'accounts';
	if(!login){//Creating new account
		if(elements[1].value==pass.value&&pass.value.length>0){
		    let data = {'email': email.value, 'password': pass.value};
		    ASYNC_REQUEST('put', url, data, function(data)
		    		{
		    			if(data!=0)
		    				window.location.replace(window.location.href+'movies?accID='+data);
		    			else console.log('Email already in use!');
		    		});
		}
		else{
			console.log('Password & Confirmation password must be not empty and the same.');
		}
	}
	else{
		if(email.value.length==0||pass.value.length==0){console.log('Email and password fields cannot be empty.'); return;}
	    let data = {'email': email.value, 'password': pass.value};
	    ASYNC_REQUEST('post', url, data, function(data)
	    		{
	    			if(data!=0) window.location.replace(window.location.href+'movies?accID='+data);
	    			else console.log('Combination of password and email don\'t match');
	    		});
	}
}