function nameWarn(flag) {
	var namewarn = document.getElementById("namewarn");
	if(flag == null){
		var response = xmlhttp.responseText;
		/*是否可用服务器通过0和1状态来回复，0表示不能使用，1表示可以使用*/
		if(response == "0"){
			namewarn.innerHTML = "<img src='img/wrong.png'>"+"该用户名已被占用".fontcolor(red);
		}else
			namewarn.innerHTML = "<img src='img/right.png'>";
	}else if(flag)
		namewarn.innerHTML = "<img src='img/wrong.png'>"+"用户名格式不对".fontcolor(red);
	else
		namewarn.innerHTML = "<img src='img/wrong.png'>"+"用户名不能为空".fontcolor(red);
}

function pwwarn(id,flag) {
	if(id == "pwd"){
		var pwarn = document.getElementById("pwdwarn");
		if(flag)
			pwarn.innerHTML = "<img src='img/right.png'>";
		else
			pwarn.innerHTML = "<img src='img/wrong.png'>" + "密码格式不对".fontcolor(red);
	}else{
		var pwarn = document.getElementById("vpwdwarn");
		if(flag)
			pwarn.innerHTML = "<img src='img/right.png'>";
		else
			pwarn.innerHTML = "<img src='img/wrong.png'>" + "两次输入不匹配".fontcolor(red);
	}
}

function verifymatch(flag){
	if(flag == null){
		var response = xmlhttp.responseText;
		var vwarn = document.getElementById("safeverify");
		if(response == "0"){
			vwarn.innerHTML = "<img src='img/wrong.png'>" + "验证码错误".fontcolor(red);
		}else{
			vwarn.innerHTML = "<img src='img/right.png'>";
		}
	}else{
		vwarn.innerHTML = "<img src='img/wrong.png'>" + "验证码位数错误或存在非法字符".fontcolor(red);
	}
}