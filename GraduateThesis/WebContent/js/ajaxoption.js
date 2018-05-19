var xmlhttp;

/*获取xmlhttp对象*/
function getxmlhttp(){
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}else if(window.ActiveXObject){
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
}

/*发送局部刷新参数*/
function sendparam(url,param,callback){
	getxmlhttp();
	if(xmlhttp == null){
		alert("XMLHttpRequst对象创建失败");
		return;
	}
	if(param == null){
		xmlhttp.open("get", url, true);
	}
	else{
		xmlhttp.open("post", url, true);
		xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	}
	xmlhttp.send(param);
	xmlhttp.onreadystatechange = function(){
		if(xmlhttp.readyState==4 && xmlhttp.status==200 && callback !== null){
			callback();
		}
	}
}

/*用户名检查*/
function checkname(obj){
	var nickname = obj.value;
	if(nickname != ""){
		var reg = /^[0-9A-z_\u4e00-\u9fa5]{3,10}$/;
		if(reg.test(nickname)){
			var name = obj.value;
			sendparam("?nickname="+name, null, nameWarn);
		}else
			nameWarn(true);
	}else
		nameWarn(false);
}

/*获取手机或邮箱验证码*/
function getverifycode(obj){
	var name = obj.name;
	var value = obj.value;
	sendparam("cverifycode?"+name+"="+value, null, null);
	
}

/*安全认证*/
function safeconfirm(obj){
	var node = document.getElementsByName("verifycode")[0];
	var ownerid = node.parentNode.parentNode.name;
	var str = node.value;
	var reg = /^[0-9]{6}$/;
	if(str.length == 6 && reg.test(str)){
		if(owerid == "email")
			sendparam("emailconfirm?verifycode="+str, null, verifymatch);
		else if(owerid == "phonenum")
			sendparam("phonenumconfirm?verifycode="+str, null, verifymatch);
	}else{
		verifymatch(false);
	}
}

/*验证码刷新*/
function reverifyimg(){
	
}