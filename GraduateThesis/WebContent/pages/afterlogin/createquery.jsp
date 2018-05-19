<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%-- 问卷创建页面 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=<%=request.getContextPath() + "/"%>>
<title>问卷创建</title>
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
	</script>
<!---slider--->
<style type="text/css">
#title{
	width: 100%;
	font-size: 2em;
	font-weight: 300;
	margin:0 auto;
	display: none;
}

#enddate input{
	width: 80px;
}

.outdiv{
	width: 100%;
	min-height: 400px;
}
.autoheight{
	width: 100%;
}

.linkstyle{
	font-size: 2em;
	font-weight: 900;
	color: blue;
}

.quesdiv{

}

font{
	font-family: "华文彩云";
	font-weight: 900;
	font-size: 50px;
}
</style>
<script type="text/javascript">
var jdata;
function searched(){
	jdata= null;
	$("#newques").show();
	$("#seaques").val("");
	var pattern = $("#pattern").val();
	var $seaques = $("#seaques");
	$seaques.empty();
	$.ajax({
		type:"get",
		url:"al/searchquestion",
		data:{"pattern":encodeURI(pattern)},
		success:function(data){
			if(data!=null){
				var cdata =decodeURIComponent(data);
				jdata = JSON.parse(cdata); 
				console.log(data);
				for(var i = 0;i < jdata.length;i++){
					var $question = $("<div style='margin-lefet:70px;margin-top:60px;'></div>");
					var $link = $("<a href='javascript:void(0)' qid='"+jdata[i].questionid+"' onclick='addid(this)'></a>");
					var str = i+1+"."+jdata[i].question;
					$link.html(str);
					$question.append($link);
					$seaques.append($question);
				}
			}
		},
		dataType:"text"
	});
}


function addid(obj){
	var questionid = obj.getAttribute("qid");
	$.ajax({
		type:"get",
		url:"subquestion",
		data:{"questionid":questionid},
		success:function(data){
			if(data){
				var cdata = decodeURIComponent(data);
				jdata = JSON.parse(cdata);
				alert(jdata);
				var $que = $("<div name='question'></div>");
				var $con = $("<span name='choose'>"+jdata.question+"</span><br/>");
				$que.append($con);
				var choose = jdata.choose;
				for(var j = 0;j < choose.length;j++){
					$con = $("<span name='choose'>"+choose[j]+"</span><br/>");
					$que.append($con);
				}
				$("#questions").append($que);
				
				/* for(var i = 0;i < jdata.length;i++){
					if(jdata[i].questionid != questionid){
						continue ;
					}
					var $con = $("<span name='choose'>"+jdate[i].question+"</span><br/>");
					$que.append($con);
					var choose = jdate[i].choose;
					for(var j = 0;j < choose.length;j++){
						$con = $("<span name='choose'>"+choose[j]+"</span><br/>");
						$que.append($con);
					}
					break;
				} */
				$("#seaques").empty();
			}
		},
		dataType:"text"
	});
	alert("wancheng");
}


function subtitle(){
	var title = $("#intitle").val();
	var enddate = ""+$("#year").val()+"-"+$("#month").val()+"-"+$("#day").val();
	$.ajax({
		type:"get",
		url:"al/createquery.do",
		data:{"title":encodeURI(title),"enddate":enddate},
		success:function(data){
			if(data == 1){
				$("#titlef").hide();
				var title = $("#intitle").val();
				$("div[class=outdiv] h3").append(title);
				$("#addques").show();
			}
		},
		dataType:"text"
	});
}

function addques(){
	$("#addques").hide();
	$("#searchdiv").show();
}

function newques(){
	$("#searchdiv").hide();
	$("#newques").hide();
	$("#outer").show();
	$("#seaques").empty();
	
}

function subover() {
	$("#addques").hide();
	$("#lastbut").show();
	
}

function sured(){
	$.ajax({
		type:"get",
		async: false,
		url:"subquestion",
		data:{geturl:"ok"},
		success:function(data){
			alert("请复制调查链接:"+data);
		},
		dataType:"text"
	});
	window.location.href = "al/about";
}

/* function sured() {
	var enddate = ""+$("#year").val()+$("#month").val()+$("#day").val();
	$.ajax({
		type:"post",
		url:"al/querysave.do",
		data:{"enddate":enddate},
		success:function(data){
			if(data == 1){
				location.href="al/about";
			}
		},
		dataType:"text"
	});
} */
</script>
</head>
<body>
<%@include file="header.jsp" %>
<div class="outdiv">
	<div id="titlef">
		<input id="intitle" type="text" class="form-control"/>
		<div id="enddate" style="margin-left:200px;">
		<input type="text" id="year">
		<input type="text" id="month">
		<input type="text" id="day">
	</div>
		<span class="input-group-btn">
			<button class="btn btn-default" type="button" onclick="subtitle();">确定</button>
		</span>
	</div>
	<h3 style="text-align: center;margin-top: 30px;"></h3>
<%-- 已添加的问题显示 --%>
	<div id="questions" class="autoheight" style="margin-left: 50px;">
	</div>
	<div class="autoheight" id="changefiled" style="padding-left: 50px;">
		<div style="width:300px;margin:0 auto;display: none" id="addques">
			<a class="linkstyle" href="javascript:void(0);" onclick="addques()"><font>+</font>&nbsp;添加问题</a>
			<br>
			<div style="margin-left: 200px;">
			<button style="width: 100px;background-color: #93DA8D;color: white;" onclick="subover()">完成</button>
			</div>
		</div>
		
		<div style="margin:0 auto;display:none" id="searchdiv">
			<div style="height: 50px;margin-top: 30px;">
				<div class="col-lg-6 in-gp-tb">
					<div class="input-group">
						<input id="pattern" type="text" class="form-control" placeholder="Search for...">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button" onclick="searched();">Go!</button>
						</span>
					</div>
					<!-- /input-group -->
				</div>
			</div>
		</div>
		<div style="width:350px;margin:0 auto;display: none" id="newques">
			<a class="linkstyle" href="javascript:void(0);" onclick="newques()"><font>+</font>&nbsp;创建问题</a>
		</div>
		<div id="seaques" style="margin-left: 70px;margin-top: 30px;">
		
		</div>
	</div>
	<div id="lastbut" style="margin-left:200px;display: none;">
		<button onclick="sured()">确定</button>
	</div>
<%@include file="createquestion.jsp" %>
</div>
<%@include file="footer.jsp" %>
</body>
</html>