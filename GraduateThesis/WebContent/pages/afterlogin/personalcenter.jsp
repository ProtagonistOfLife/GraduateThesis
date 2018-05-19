<%@page import="com.github.pagehelper.PageInfo"%>
<%@page import="com.pcw.bean.User"%>
<%@page import="com.pcw.dao.UserDao"%>
<%@page import="com.pcw.dao.QueryPageDao"%>
<%@page import="javax.management.Query"%>
<%@page import="com.pcw.common.Connection"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.pcw.bean.QueryPaper"%>
<%@page import="java.util.List"%>
<%@page import="com.github.pagehelper.PageHelper"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%--网页中为个人中心 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=<%=request.getContextPath() + "/"%>>
<title>个人中心</title>
<!---css-style--->
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />
<!---css-style--->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Diving Centre Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!---js--->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<!---js--->
</head>
<body>
<%@include file="header.jsp" %>	
<!---banner--->
	<!---content--->
	<!-- <div style="height: 50px;margin-top: 30px;"> -->
	<div style="min-height: 500px;margin-top: 30px;">
		<div style="width: 100%;display: inline-block;">
			<div class="col-lg-6 in-gp-tb">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search for...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">Go!</button>
					</span>
				</div><!-- /input-group -->
			</div>
			<div style="font-size: 2em;font-weight: 900;padding-left:100px;display: inline-block;">
				<a href="al/createquery">
				<font style="font-family: '华文彩云';font-weight: 900;font-size: 50px;">+</font>&nbsp;创建问卷
				</a>
			</div>
			<div id="queries" style="margin-left:60px; ">
				<c:forEach items="${queries}" var="query" varStatus="qs">
					<div id="qp_${query.paperid}" style="margin-left: 50px;margin-top: 60px">
					<span style="display: inline-block;width: 500px;">
					${qs.count}.<a href="al/querypage?paperid=qp_${query.paperid}">${query.papername}</a>
					</span>
					<span><a href="al/deletequery.do">删除</a></span>
					</div>
				</c:forEach>
				<div style="margin-left: 100px;margin-top: 40px;">
				  <p>一共${page.pages}页</p>
			      <a href="al/about?page=${page.firstPage}">第一页</a>
			      <a href="al/about?page=${page.nextPage}">下一页</a>
			      <a href="al/about?page=${page.prePage}">上一页</a>
			      <a href="al/about?page=${page.lastPage}">最后页</a>
				</div>
			</div>
		</div>
		<div id="items">
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>