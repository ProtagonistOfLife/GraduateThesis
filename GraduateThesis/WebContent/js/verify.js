function check(spanarea,message,flag) {
	if(flag)
		spanarea.innerHTML=message.fontcolor("green");
	else
		spanarea.innerHTML=message.fontcolor("red");
}

/*function emailverify(){
	var phonespan = document.getElementById("phonespan");
	var emailspan = document.getElementById("emaispan");
	emailspan.a
}*/

function peverify(pe){
	var temp = document.getElementById(pe);
	if(pe == "emailspan"){
		
	}else if(pe == "phonespan"){
		
	}
}

function pwcheck(spanname){
	var pw = document.getElementById("pw");
	var vpw = document.getElementById("vpw");
	var spnode = document.getElementById(spanname);
	var flag = pw == vpw;
	
}

/*select标签的option使用*/
function onloadselect(){
	var year = document.createTextNode("请选择");
	var option = document.createElement("option");
	option.appendChild(year);
	option.setAttribute("value", null);
	var root = document.getElementById("selectyear");
	root.appendChild(option);
	var now = new Date();
	var temp = now.getFullYear();
//	年选择
	for(var i=1980;i<=temp;i++){
		option = document.createElement("option");
		option.setAttribute("value", i);
		year = document.createTextNode(i);
		option.appendChild(year);
		root.appendChild(option);
	}
//	月选择
	var month = document.createTextNode("请选择");
	option = document.createElement("option");
	option.appendChild(month);
	option.setAttribute("value", null);
	root = document.getElementById("selectmonth");
	root.appendChild(option);
	for(var i=1;i<13;i++){
		option = document.createElement("option");
		option.setAttribute("value", i);
		month = document.createTextNode(i);
		option.appendChild(month);
		root.appendChild(option);
	}
//	日选择
	var day = document.createTextNode("请选择");
	option = document.createElement("option");
	option.appendChild(day);
	option.setAttribute("value", null);
	root = document.getElementById("selectday");
	root.appendChild(option);
}

/*日期动态处理*/
function changed(field){
	var now = new Date();
	var temp = document.getElementById(field);
	var option = null;
	var root = null;
//	根据年的编号处理月份的选择项
	if(field == "selectyear"){
		root = document.getElementById("selectmonth");
		var month = null;
		document.getElementById("selectmonth").innerHTML = "<option value='null'>请选择</option>";
		document.getElementById("selectday").innerHTML = "<option value='null'>请选择</option>";
		if(temp.value == now.getFullYear()){
			for(var i=1;i<=now.getMonth()+1;i++){
				option = document.createElement("option");
				option.setAttribute("value", i);
				month = document.createTextNode(i);
				option.appendChild(month);
				root.appendChild(option);
			}
		}else{
			for(var i=1;i<=12;i++){
				option = document.createElement("option");
				option.setAttribute("value", i);
				month = document.createTextNode(i);
				option.appendChild(month);
				root.appendChild(option);
			}
		}
//		根据月份动态处理显示日的选项
	}else if(field == "selectmonth"){
		root = document.getElementById("selectday");
		document.getElementById("selectday").innerHTML = "<option value='null'>请选择</option>";
		var maxdays = null;
		if(temp.value == now.getMonth()+1){
			if(document.getElementById("selectyear").value == now.getFullYear()){
				maxdays = now.getDate();
			}
		}else{
			var year = document.getElementById("selectyear").value;
			var month = document.getElementById("selectmonth").value;
			if(month == 2){
				if(year%400==0 ||(year%100!=0&&year%4==0))
					maxdays = 29;
				else
					maxdays = 28;
			}else{
				if(month < 8){
					if(month%2 == 0)
						maxdays = 30;
					else
						maxdays = 31;
				}else{
					if(month%2 == 0)
						maxdays = 31;
					else
						maxdays = 30;
				}
			}
		}
		var day = null;
		for(var i=1;i<=maxdays;i++){
			option = document.createElement("option");
			option.setAttribute("value", i);
			day = document.createTextNode(i);
			option.appendChild(day);
			root.appendChild(option);
		}
	}
}

//号码提交
function substr(filed){
	var acturl;
	var verifycode = $("#"+filed+"_inp").val();
	if(filed == "phonenum"){
		acturl = "";
		return ;
	}
	else if(filed == "email")
		acturl = "emailveryfy";
	$.ajax({
		type:"post",
		url:acturl,
		data:{email:verifycode},
		success:function(data){
			$("#bt_email").attr("disabled",true);
			$("#bt_phone").attr("disabled",true);
		},
		dataType:"text"
		/*success:function(data){
			//当服务端返回结果为1时表示验证成功
			if(data == "1"){
				veryflag = true;
				$("#verifycode").attr("disabled",true);
			}
		},
		dataType:text*/
	});
}

/*手机或邮箱验证码认证目前设置为二选一状态*/
function verified(filed) {
//	控制邮箱或短信验证只能有一个显示
	/*if(filed == "phonenum"){
		var emailspan = document.getElementById("email");
		if(emailspan.getElementsByTagName("span").length > 2)
			emailspan.removeChild(emailspan.getElementsByTagName("span")[2]);
	}else{
		var phonespan = document.getElementById("phonenum");
		if(phonespan.getElementsByTagName("span").length > 2)
			phonespan.removeChild(phonespan.getElementsByTagName("span")[2]);
	}*/
	var filedspan = null;
	if(filed == "phonenum")
		filedspan = document.getElementById("email");
	else
		filedspan = document.getElementById("phonenum");
	if(filedspan.getElementsByTagName("span").length > 2)
		filedspan.removeChild(filedspan.getElementsByTagName("span")[2]);
//	验证输入框的创建
	substr(filed);
	var warnfiled = document.getElementById(filed);
	if(warnfiled.getElementsByTagName("span").length < 3){
		var vspan = document.createElement("span");
		var blankspan = document.createElement("span");//一个占位的span
		var vinput = document.createElement("input");
		var vbutton = document.createElement("button");
		var btname = document.createTextNode("验证");
		var verifywarn = document.createElement("span");
		
		vspan.setAttribute("id", "verify");
		vspan.setAttribute("class", "confirmspan");
		blankspan.setAttribute("class", "filedname");
		blankspan.setAttribute("id", "");
		vinput.setAttribute("type", "text");
		vinput.setAttribute("class", "textfiled");
		vinput.setAttribute("placeholder", "请输入验证码");
		vinput.setAttribute("id", "verifycode");
		vbutton.setAttribute("id", "vcode");
		vbutton.appendChild(btname);
		vbutton.setAttribute("type", "button");
		verifywarn.setAttribute("id", "safeverify");
		vspan.appendChild(blankspan);
		vspan.appendChild(vinput);
		vspan.appendChild(vbutton);
		vspan.appendChild(verifywarn);
		warnfiled.appendChild(vspan);
		
//		“验证”按钮的点击事件
		$("#vcode").click(function(){
			var verifycode = $("#verifycode").val();
			var acturl = $("#vcode").parent().parent().attr("id");
			if(acturl == "phonenum")
				acturl = "";
			else if(acturl == "email")
				acturl = "emailmatch";
			$.ajax({
				type:"get",
				url:acturl,
				data:{"verifycode":verifycode},
				success:function(data){
					//当服务端返回结果为1时表示验证成功
					if(data == 1){
						veryflag = true;
						$("#vcode").attr("disabled",true);
					}
				},
				dataType:"text"
			});
		});
	}
}

window.onload = onloadselect;