<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
	<base href="/GraduateThesis/">
	<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
	<title>问卷调查登录页面</title>
	<link rel="stylesheet" href="css/framedesign.css" type="text/css">
	<link rel="stylesheet" href="css/fontdesign.css" type="text/css">
	<script type="text/javascript" src="js/ajaxoption.js"></script>
	<script type="text/javascript">
		function redir() {
			location.href="http://localhost/GraduateThesis/regist.jsp";
		}
	</script>
</head>
<body>
<%request.setAttribute("englishname", "Login Page");
request.setAttribute("name","用户登录");%>
<%@include file="top.jsp" %>
<div class="formdiv">
	<!-- <form action="" method="post" onsubmit="formcheck()"> -->
	<form action="Loginservlet" method="post">
		<span class="filedname">账号：</span>
		<input class="textfiled" name="id" type="text" size='15' placeholder="账号/用户名/手机号">
		<br>
		<span class="filedname">密码：</span>
		<input class="textfiled" name="password" type="password" size='15' placeholder="请输入密码">
		<br>
			<img alt="验证码" src="/GraduateThesis/getverifiedimg" onclick="reverifyimg()">
		<font face="行楷" class="fontlink">换一张</font>
		<input class="verify" name="verify" type="text" size='6' placeholder="验证码">
		<br>
		<input class="submit" type="submit" value="提交">
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input class="submit" type="button" value="注册" onclick="redir()"/>
	</form>
</div>
<%@include file="foot.jsp" %>
</body>
</html>