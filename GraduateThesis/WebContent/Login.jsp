<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
	<base href="/GraduateThesis/">
	<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
	<title>�ʾ�����¼ҳ��</title>
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
request.setAttribute("name","�û���¼");%>
<%@include file="top.jsp" %>
<div class="formdiv">
	<!-- <form action="" method="post" onsubmit="formcheck()"> -->
	<form action="Loginservlet" method="post">
		<span class="filedname">�˺ţ�</span>
		<input class="textfiled" name="id" type="text" size='15' placeholder="�˺�/�û���/�ֻ���">
		<br>
		<span class="filedname">���룺</span>
		<input class="textfiled" name="password" type="password" size='15' placeholder="����������">
		<br>
			<img alt="��֤��" src="/GraduateThesis/getverifiedimg" onclick="reverifyimg()">
		<font face="�п�" class="fontlink">��һ��</font>
		<input class="verify" name="verify" type="text" size='6' placeholder="��֤��">
		<br>
		<input class="submit" type="submit" value="�ύ">
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input class="submit" type="button" value="ע��" onclick="redir()"/>
	</form>
</div>
<%@include file="foot.jsp" %>
</body>
</html>