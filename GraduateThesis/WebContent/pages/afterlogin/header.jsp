<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <script type="text/javascript">
	window.onload = function(){
		var paths = location.pathname.split("/");
		var classname = paths[paths.length-1];
		/* var classname = path.split(".")[0]; */
		if(classname in {'index':0,'about':1,'services':2,'codes':3}){
			var current = document.getElementById(classname);
		/* 	current.setAttribute("class", "active "); */
			current.setAttribute("class", "myactive ");
		}
	}
	
	function search(acturi){
		var pattern = $("#pattern").val();
		$.ajax({
			type:"get",
			url:acturi,
			data:{"pattern":pattern},
			success:function(data){
				
			},
			dataType:"text"
		});
	}
</script>
<!-- 自己添加的 -->
<style>
	.navbar-brand h1 a{
		color: black;
	}
	
	.myactive{
		background-color: yellow;
	}
</style>
<!---header--->
<!-- 本div中的内容为自定义的div，不为原模板中所有 -->
<!-- <div style="background-color: #93DA8D;"> -->
<div style="background-color: #BFCDAF;">
	<img alt="logo" src="img/sign.png" style="width: 200px;height: 160px;margin-left: 70px;">
	<div id="up_right" style="float: right;padding-top: 50px;padding-right: 30px;">
		<span id="user">${usermsg}</span>&nbsp;&nbsp;
		<a href="logout" id="logout" class="logout_link">注销</a>
	</div>
</div>
<div class="header-section" style="background-color: #BFCDAF;">
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
	<!---Brand and toggle get grouped for better mobile display--->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>				  
					<div class="navbar-brand">
						<h1><a href="index">问卷调查系统</a></h1>
					</div>
				</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li id="index"><a href="al/index"  style="color: black;">主页<span class="sr-only">(current)</span></a></li>
						<li id="about"><a href="al/about"  style="color: black;">个人中心</a></li>
						<li id="services"><a href="al/services"  style="color: black;">调查中心</a></li>
						<li id="codes"><a href="al/codes"  style="color: black;">信息中心</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</div>