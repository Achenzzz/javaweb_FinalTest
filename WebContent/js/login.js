
  
//用户名焦点事件
$(document).ready(function() {
	$("#username").focus(function() {
		$(this).css("background-color", "#C0C0C0");
	});
});

$(document).ready(function() {
	$("#username ").blur(function() {
		$(this).css("background-color", "");
		if($("#username").val()==""){
			document.getElementById("checkError1").innerText="用户名不能为空!";
		}
		else{
			document.getElementById("checkError1").innerText="";
		}
	});
});
//密码焦点事件
$(document).ready(function() {
	$("#password").focus(function() {
		$(this).css("background-color", "#C0C0C0");
	});
});

$(document).ready(function() {
	$("#password ").blur(function() {
		$(this).css("background-color", "");
		if($("#password").val()==""){
			document.getElementById("checkError2").innerText="密码不能为空！"
		}
		else{
			document.getElementById("checkError2").innerText="";
		}
	});
});
//验证码焦点事件
$(document).ready(function() {
	$("#usercode").focus(function() {
		$(this).css("background-color", "#C0C0C0");
	});
});

$(document).ready(function() {
	$("#usercode ").blur(function() {
		$(this).css("background-color", "");
		if($("#usercode").val()==""){
			document.getElementById("checkError3").innerText="验证码不能为空！"
		}
		else{
			document.getElementById("checkError3").innerText="";
		}
	});
});

/*
var xmlHttp;

//创建XMLRequest对象
function createXmlHttp() {
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	} else {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

}

function ajaxCheckLogin() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var usercode = document.getElementById("usercode").value;
	console.log(username);
	console.log(password);
	console.log(usercode);
	var data="Username=" +username+ "&Password="+password+ "&Usercode="+usercode;
	
	xmlHttp = new XMLHttpRequest();
	
	xmlHttp.open("post", "LoginController", true);
	xmlHttp.setRequestHeader("Content-Type", "application/x-ww-form-urlencoded");
	xmlHttp.send(data);
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			var response = xmlHttp.responseText;
			var json = JSON.parse(response);
			if (json.code == 0) {
				window.location.href = "main.jsp";
			} else {
				document.getElementById("checkError").innerText = json.info;
			}
		}
	}

}
	
*/
//登录验证
	function ajaxCheckLogin() { 
	 $.ajax({
	            type: "POST",
	            url: "LoginController",
	            contentType: "application/x-www-form-urlencoded;charset=utf-8",
	            data:{Username:$("#username").val(),Password:$("#password").val(),UserCode:$("#usercode").val()},
	            dataType: "json",	           
	            success: function (data) { 
	            		//console.log(data);
	            	if(data.code == 0)
	            	{
	            		window.location.href = "main.jsp";
	            	}	else
	            	{
	            		$("#checkError").html(data.info);
	            	}
	       				            		          		
	            		            },
	            error: function (error) {
	                alert("error=" + error);
	            }
	})
	}
