

//加载省份
function fillProvince(){
$.ajax({
	type:"post",
	url:"queryProvinceCityController",
	dataType:"json",
	success:function(response){
		var provinceElement=document.getElementById("province");
		provinceElement.options.length=0;
		provinceElement.add(new Option("请选择省份"));
		for(index=0;index<response.length;index++){
			provinceElement.add(new Option(response[index]));
		}
		
	}
});
}

//获取城市
$(document).ready(function()
{
	fillProvince();
	$("#province").change( function(e)
	{
		$("#city").empty();
		$("#city").append($("<option>").val("").text("请选择城市"));
		province_correct=true;
		console.log($("#province").val());
		$("#provinceError").text("");
		var provinceCode=$("#province").val();
			$.ajax({
			type:"post",
			url:"queryProvinceCityController",
			data:{provinceCode:provinceCode},
			dataType:"json",
			success:function(response)
			{
			var cityElement=document.getElementById("city");
		     cityElement.options.length=0;
		     cityElement.add(new Option("请选择城市"));
				for(index=0;index<response.length;index++)
				{
					cityElement.add(new Option(response[index]));
				}
			}
		});
	});
}
)
//城市被选中
$(document).ready(function(){
  $("#city").change(function(){
    city_correct=true;
  });
});
//验证用户名
//用户名焦点事件
$(document).ready(function() {
	$("#username").focus(function() {
		$(this).css("background-color", "#C0C0C0");
	});
});

$(document).ready(function() 
{

	$("#username ").blur(function() 
	{
		$(this).css("background-color", "");
		if($("#username").val()=="")
		{
			document.getElementById("checkError1").innerText="用户名不能为空!";
		}
		else{
			
			$.ajax(
			{
			type:"post",
			url:"CheckuserNameController",
			data:{username:$("#username").val()},
			dataType:"json",
			success:function(response)
			{
			if(response.code==0)
			{
				document.getElementById("checkError1").innerText="";
				Susername=true;
			}
			else
			{
				document.getElementById("checkError1").innerText=response.info;
			}
			
			}
		})
	}
	})
})
//验证真实姓名
$(document).ready(function() {
	$("#name").focus(function() {
		$(this).css("background-color", "#C0C0C0");
	});
});

$(document).ready(function() {
	$("#name").blur(function(){
	$(this).css("background-color", "");
	var name=$("#name").val();
	var reg=/^(([a-zA-Z+\.?\·?a-zA-Z+]{2,30}$)|([\u4e00-\u9fa5+\·?\u4e00-\u9fa5+]{2,30}$))/;
	if(name=="")
	{
		document.getElementById("checkError2").innerText="姓名不能为空!";
	}
	else
	{
		if(!(reg.test(name)))
		{
				document.getElementById("checkError2").innerText="请输入您的中文真实名字";
        }
        else
        {   document.getElementById("checkError2").innerText=""; Sname=true;			}
	}
	})
});

//验证邮箱地址
$(document).ready(function() {
	$("#email").focus(function() {
		$(this).css("background-color", "#C0C0C0");
	});
});

$(document).ready(function() {
	$("#email").blur(function(){
	$(this).css("background-color", "");
	var email=$("#email").val();
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

	if(email=="")
	{
		document.getElementById("checkError3").innerText="邮箱不能为空!";
	}
	else
	{
		if(!(reg.test(email)))
		{
				document.getElementById("checkError3").innerText="请输入正确的邮箱地址!";
        }
        else
        {   document.getElementById("checkError3").innerText=""; Semail=true;			}
	}
	})
});

//验证密码
$(document).ready(function() {
	$("#password").focus(function() {
		$(this).css("background-color", "#C0C0C0");
	});
});

$(document).ready(function() {
	$("#password").blur(function(){
	$(this).css("background-color", "");
	var password=$("#password").val();
	if(password=="")
	{
		document.getElementById("checkError4").innerText="密码不能为空!";
	}
	else
	{		
		document.getElementById("checkError4").innerText=""; Spassword=true;
	}
	})
});

//再验证密码
$(document).ready(function() {
	$("#repassword").focus(function() {
		$(this).css("background-color", "#C0C0C0");
	});
});

$(document).ready(function() {
	$("#repassword").blur(function(){
	$(this).css("background-color", "");
	var repassword=$("#repassword").val();
	if(repassword=="")
	{
		document.getElementById("checkError5").innerText="密码不能为空!";
	}
	else
	{		
		if(repassword==$("#password").val()){document.getElementById("checkError5").innerText=""; Srepassword=true;}
		else{
			document.getElementById("checkError5").innerText="两次密码不一致！";
			
		}
	}

	})
});



function ajaxRegister(){
var Susername=$("#checkError1").val();
var Sname=$("#checkError2").val();
var Semail=$("#checkError3").val();
var Spassword=$("#checkError4").val();
var Srepassword=$("#checkError5").val();
var province_correct=$("#provinceError").val();
var city_correct=$("#cityError").val();
console.log(Sname);
		if(Susername==""&&Sname==""&&Semail==""&&Spassword==""&&Srepassword==""&&province_correct==""&&city_correct==""){
		$.ajax({
	            type: "post",
	            url: "RegisterController",
	            contentType: "application/x-www-form-urlencoded;charset=utf-8",
	            data:{Username:$("#username").val(),Name:$("#name").val(),Email:$("#email").val(),Province:$("#province").val(),City:$("#city").val(),Password:$("#password").val()},
	            dataType: "json",	           
	            success: function (data) { 
	       				if(data.code==1) window.location.href = "login.html";      
	       				else{
	       					alert("注册失败！请重新注册！");
	       				}		          		
	            }
			});
		}
		 
}



