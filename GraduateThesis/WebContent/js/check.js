function pwcheck(id){//密码检查
	var firstpw = document.getElementById("pwd").value;
	var reg =  /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/;
	if(id == "pwd"){
		pwwarn(id,reg.test(firstpw));
	}else{
		var secondpw = document.getElementById("vpwd").value;
		pwwarn(id, firstpw==secondpw);
	}
}