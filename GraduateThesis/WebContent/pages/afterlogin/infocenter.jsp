<%@page import="java.util.Calendar"%>
<%@page import="com.pcw.dao.UserDao"%>
<%@page import="com.pcw.common.Connection"%>
<%@page import="com.pcw.bean.User"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%--网页中为信息中心 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=<%=request.getContextPath() + "/" %>>
<title>信息中心</title>
<!---css-style--->
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />
<!---css-style--->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<meta name="keywords" content="Diving Centre Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!---js--->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<!---js--->
<style type="text/css">
	h3.w3_head {
    font-size: 25px;
    display: block;
    letter-spacing: 4px;
    margin-top: 5px;
    text-transform: uppercase;
    color: #ecb731;
	}
	div.content li{
		margin-top: 30px;
		margin-left:80px;
		list-style: none;
		font-size: 20px;
	}
	.namesp {
		display: inline-block;
		width: 100px;
	}
</style>
</head>
<% 
String username = (String)session.getAttribute("usermsg");
User user = Connection.getSession().getMapper(UserDao.class).findByName(username);
String gender = "男";
if(user.getGender() == 1)
	gender = "女";
Calendar cal = Calendar.getInstance();
int nyear = cal.get(Calendar.YEAR);
int nday = cal.get(Calendar.DAY_OF_YEAR);

cal.setTime(user.getBirth());
int pyear = cal.get(Calendar.YEAR);
int pday = cal.get(Calendar.DAY_OF_YEAR);
int age = nyear - pyear;
if(nday < pday){
	age--;
}
request.setAttribute("gender", gender);
request.setAttribute("age", age);
session.setAttribute("user", user);
%>
<body>
	<%@include file="header.jsp" %>
	<!---content--->
	<div class="content">
		<div style="margin-top: 50px;margin-left: 300px;margin-right: 200px;margin-bottom: 100px;background-color:#d9edf7 ;padding-bottom: 35px;padding-top: 35px;padding-left: 30px;">
		<h3 class="w3_head w3_head1">个人信息</h3>
			<ul>
				<li><span class="namesp">账号</span>:${user.userid }</li>
				<li><span class="namesp">用户名</span>: ${user.username }</li>
				<li><span class="namesp">性别</span>:${gender}</li>
				<li><span class="namesp">年龄</span>: ${age}岁</li>
				<li><span class="namesp">Email</span>: <a href="mailto:${user.email }">${user.email}</a></li>
				<li><span class="namesp">电话号码</span>: ${user.phonenum }</li>
			</ul>
		</div>
	<!---typography--->
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>