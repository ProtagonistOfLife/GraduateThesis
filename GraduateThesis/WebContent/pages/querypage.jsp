<%@page import="com.pcw.bean.Question"%>
<%@page import="java.util.List"%>
<%@page import="com.pcw.dao.QuestionDao"%>
<%@page import="com.pcw.dao.QueryPageDao"%>
<%@page import="com.pcw.common.Connection"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.pcw.bean.QueryPaper"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 
    <%-- ÎÊ¾íÏÔÊ¾Ò³Ãæ --%>
    <%String qp_id = request.getParameter("paperid");
    	SqlSession sqlsession = Connection.getSession();
    	QueryPageDao qpd = sqlsession.getMapper(QueryPageDao.class);
    	QuestionDao qd = sqlsession.getMapper(QuestionDao.class);
    	long paperid = Long.parseLong(qp_id.split("_")[1]);
    	QueryPaper query = qpd.findById(paperid);
   		request.setAttribute("query", query);
    	List<Question> questions = qd.findByQuery(paperid);
    	request.setAttribute("questions", questions);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=<%=request.getContextPath() + "/"%>>
<title>${query.papername}</title>
<script src="js/owl.carousel.js"></script>
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
</head>
</head>
<body>
<%@include file="afterlogin/header.jsp" %>
<h3>
${query.papername}
</h3>
<div id="items" style="margin-left: 100px;margin-top: 60px;">
<form action="" method="post">
<c:forEach items="${questions}" var="question" varStatus="aa">
	<div style="margin-top: 50px;">${aa.count}.${question.question}</div>
	<div>${question.choose}</div>
<c:set value="${ fn:split(question.choose,';') }" var="pointer" />
	<c:forEach items="pointer" var="choose" varStatus="ord">
		<div name = "choose">
		<input type="radio" name="q_${question.questionid} value=${ord.count}"/>${choose}
		</div>
	</c:forEach>
<%-- 	<div>${question.result}</div> --%>
</c:forEach>
<input style="width: 150px;background-color: green;" type="submit">
</form>
</div>
<%@include file="afterlogin/footer.jsp" %>
</body>
</html>