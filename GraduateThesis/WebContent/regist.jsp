<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<base href=<%=request.getContextPath()+"/" %>>
	<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
	<title>用户注册</title>
	<link rel="stylesheet" href="css/framedesign.css" type="text/css" />
	<link rel="stylesheet" href="css/fontdesign.css" type="text/css">
	<script type="text/javascript" src="js/verify.js" charset="gbk"></script>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js" charset="gbk"></script>
	<!-- 注册提交按钮的设置 -->
	<script type="text/javascript">
	//标记,用于标记邮箱验证是否成功的标记
		var veryflag = false;
	//测试时暂时为true
		//var veryflag = true;
		
		$(function(){
	//		提交按钮的点击事件
			$("#submits").click(function(){
				if(veryflag){
					$("#fm_regist").submit();
				}
			});
		});
	</script>
</head>
<body>
	<c:set var="englishname" value="User Registration Information Form" scope="request"></c:set>
	<c:set var="name" value="用户注册信息表" scope="request"></c:set>
	<%@include file="top.jsp" %>
	<div class="maxwidth">
		<div class="formdiv">
			<form action="regist" method="post" id="fm_regist">
				<span class="filedname">用户名：</span><input class="textfiled" maxlength="9" type="text" name="nickname" size="10" placeholder="输入唯一用户名">
				<span id="namewarn"></span>
				<br>
				<span class="filedname">性别：</span>
				<input type="radio" name="sex" value="男" id="m" checked><label for="m">男</label>
				<input type="radio" name="sex" value="女" id="f"><label for="f">女</label>
				<br>
				<span class="filedname">出生日期：</span>
				<select id="selectyear" name="year" onchange="changed('selectyear')">
				</select>年<!-- 准备通过js来实现 -->
				<select id="selectmonth" name="month" onchange="changed('selectmonth')"></select>月
				<select id="selectday" name="day"></select>日
				<br>
				<span class="filedname">密码：</span><input id="pwd" class="textfiled" maxlength="16" type="password" name="password" size="16" placeholder="请输入8~16位密码">
				<span id="pwdwarn"></span>
				<br>
				<span class="filedname">确认密码：</span><input id="vpwd" class="textfiled" maxlength="16" type="password" size="16" placeholder="请重新输入次密码">
				<span id="vpwdwarn"></span>
				<br>
				<span class="confirmspan" id="phonenum">
					<span class="filedname">电话号码：</span><input class="textfiled" type="text" name="phonenum" id="phonenum_inp" size="15" placeholder="请输入电话号码">
					<button id="bt_phone" onclick ="verified('phonenum')" type="button">认证</button>
					<span id="phonewarn"></span>
				</span>
				<br>
				<span class="confirmspan" id="email">
					<span class="filedname">email:</span><input class="textfiled" type="text" name="email" id="email_inp" size="20" placeholder="请输入电话号码">
					<button id="bt_email" onclick ="verified('email')" type="button">认证</button>
					<span id="emailwarn"></span>
				</span>
				<br>
				<input class="submit" type="reset" value="重置">
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="submits" class="submit" type="button" value="注册"/>
			</form>
		</div>
	</div>
	<%@include file="foot.jsp" %>
</body>
</html>