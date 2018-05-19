<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=<%=request.getContextPath() + "/"%>>
<title>${etitle}</title>
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
<!---fonts-->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Contrail+One' rel='stylesheet' type='text/css'>
<!---fonts-->
<link href="css/owl.carousel.css" rel="stylesheet">
<style type="text/css">
	#emsgdiv{
		width: 100%;
		height:600px;
	}
	
	#msg{
		font-size: 3em;
		margin-top: 100px;
		margin-left: 400px;
	}
	
	#relink{
		color: blue;
		text-decoration: underline;
		margin-top: 20px;
		margin-left: 600px;
	}
</style>
<%-- 
	 etitle		表示错误页面的标题
	 msg		表示错误的信息提示
	 relink		表示错误页面中的返回链接信息
	 rename		表示错误页面中返回链接的名称
 --%>
</head>
<body>
	<%@include file="afterlogin/header.jsp" %>
	<div id="emsgdiv">
	<div id="msg">
	${msg}
	</div>
	<div id="relink">
		<a href="${relink}">${rename}</a>
	</div>
	</div>
	<%@include file="afterlogin/footer.jsp" %>
</body>
</html>