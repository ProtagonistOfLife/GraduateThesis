<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%-- 问题创建 --%>
<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=<%=request.getContextPath() + "/"%>>
<title>问题创建</title>
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
<script src="js/owl.carousel.js"></script>
	<script>
		$(document).ready(function() {
		$("#owl-demo").owlCarousel({
			items : 1,
			lazyLoad : true,
			autoPlay : true,
			navigation : false,
			navigationText :  false,
			pagination : true,
		});
		});
	</script> --%>
<!---slider--->
<style type="text/css">
	.outer{
		/* min-height: 500px; */
		padding-left: 90px;
		width: 100%;
		display: none;
	}
	
</style>
<script type="text/javascript">
var chid = 0;
var choose = "ABCDEFGHIJKLMNOPQRST";
function addchoose() {
	if($("#overed span[name=choose]").length == 0){
		var $que = $("<div name='question'></div>");
		var $con = $("<span name='choose'>"+$("#question").val()+"</span><br/>");
		$que.append($con);
		$("#overed").append($que);
		$("#question").hide();
		$("#choose").show();
		$("#question").val("");
	}else{
		var $con = $("<span  name='choose'>"+choose.charAt(chid)+"\."+$("#choose").val()+"</span><br/>");
		$("#overed div[name='question']").append($con);
		$("#choose").val("");
		chid++;
	}
	
}

//本方法主要使用于获取两题随机问卷的
function qsubmit() {
	$.ajax({
		type:"get",
		url:"getquestions",
		success:function(data){
			if(data){
				$("changefiled").hide();
				$("#outer").hide();
				$("#tq").show();
			}else{
				dosubmit();
			}
		},
		dataType:"json"
	});
}
</script>
<%-- </head>
<body>
<%@include file="header.jsp" %> --%>
<div id="outer" class="outer">
	<div id="overed"></div>
	<input id="question" type="text" style="width: 500px;"/>
		<div>
			<input id="choose" type="text" style="width: 500px;display: none;"/>
			<a href="javascript:void(0);" onclick="addchoose()">+添加选项</a>
		</div>
	<button onclick="qsubmit()">完成</button>
</div>
<%@include file="twoquestion.jsp" %>
<%-- <%@include file="footer.jsp" %> 
</body>
</html>--%>