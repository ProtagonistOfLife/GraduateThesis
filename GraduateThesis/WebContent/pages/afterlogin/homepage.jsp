<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
     <%--网页中为个人中心 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=<%=request.getContextPath() + "/"%>>
<title>主页</title>
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
</head>
<body>
	<%@include file="header.jsp" %>
	<!--bannerslider-->
	<!---content--->
	<div class="content">
		
	<div id="container">
		<div class="welcome-section">
			<div class="container">
			<h2>热门调查</h2>
				<span></span>
				<div class="welcome-grids" onclick="javascript:windows.location='https://www.wenjuan.com/lib_detail_full/51dfd6899b9fbe6fc37051e9'">
					<div class="col-md-4 welcome-grid">
						<div class="wel-bottom  hvr-bounce-to-bottom">
							<h4><!-- learn to dive -->问卷1</h4>
							<p><!-- Fusce euismod consequat ante. Lorem ipsum dolor sit amet, cosectetuer adipiscing elit. Pellentesque sed dolor. Aliquam congue fermentum nisl. --> </p>
							<div style="width: 300px;height: 150px">
							<p>你是否有网购经历？	<br>
							你网购的频率是？<br>
							你一般会在网上买哪些商品？</p>
							</div>
						</div>
					</div>
					<div class="col-md-4 welcome-grid" onclick="javascript:windows.location='https://www.wenjuan.com/lib_detail_full/520317089b9fbe2bbb650f7b'">
						<div class="wel-bottom hvr-bounce-to-bottom">
							<h4><!-- diving equipment -->问卷2</h4>
							<p><!-- Fusce euismod consequat ante. Lorem ipsum dolor sit amet, cosectetuer adipiscing elit. Pellentesque sed dolor. Aliquam congue fermentum nisl. --> </p>
							<div style="width: 300px;height: 150px;">
							<p>工作性质<br>
							受教育程度<br>
							在本公司工作时间</p>
							</div>
						</div>
					</div>
					<div class="col-md-4 welcome-grid" onclick="">
						<div class="wel-bottom hvr-bounce-to-bottom">
							<h4><!-- rent a boat online -->问卷3</h4>
							<p><!-- Fusce euismod consequat ante. Lorem ipsum dolor sit amet, cosectetuer adipiscing elit. Pellentesque sed dolor. Aliquam congue fermentum nisl.  --> </p>
							<div style="width: 300px;height: 150px;">
							<p>我认为在本公司我会有很好的发展<br>
							我认为未来在公司内部我还有充分的发展空间<br>
							我对自己的收入与企业经营业绩的关联度感到</p>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<!---testimonials--->
		<div class="testimonials">
			<div class="container">
				<h3><!-- testimonial --></h3>
				<span></span>
				<div id="owl-demo" class="owl-carousel">
					<div class="item">
						<div class="col-md-2 testmonial-img">
							<img src="images/t1.png" class="img-responsive" alt=""/>
						</div>
						<div class="col-md-10 testmonial-text">
							<p><!-- Lorem ipsum dolor sit amet, offendit volutpat sea ex, at omnium scripta pro, at omnium scripta pro, ei mea oratio malorum forensibus. ei mea oratio malorum forensibus. Sed ei omnes laoreet posidonium ei mea oratio malorum forensibus. --></p>
							<!-- <h4><a href="#">John Doe</a></h4> -->
							<h4><a href="https://www.wenjuan.com/lib_detail_full/51e688759b9fbe76c408db2d">中学生上网情况调查</a></h4>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="item">
						<div class="col-md-2 testmonial-img">
						</div>
						<div class="col-md-10 testmonial-text">
							<p><!-- Lorem ipsum dolor sit amet, offendit volutpat sea ex, at omnium scripta pro, at omnium scripta pro, ei mea oratio malorum forensibus. ei mea oratio malorum forensibus. Sed ei omnes laoreet posidonium ei mea oratio malorum forensibus. --></p>
							<!-- <h4><a href="#">Olivia Grosh</a></h4> -->
							<h4><a href="https://www.wenjuan.com/lib_detail_full/51dfd6899b9fbe6fc37051eb">大学生就业意向调查</a></h4>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="item">
						<div class="col-md-2 testmonial-img">
							<img src="images/t3.png" class="img-responsive" alt=""/>
						</div>
						<div class="col-md-10 testmonial-text">
							<p><!-- Lorem ipsum dolor sit amet, offendit volutpat sea ex, at omnium scripta pro, at omnium scripta pro, ei mea oratio malorum forensibus. ei mea oratio malorum forensibus. Sed ei omnes laoreet posidonium ei mea oratio malorum forensibus. --></p>
							<!-- <h4><a href="#">Johnson </a></h4> -->
							<h4><a href="https://www.wenjuan.com/lib_detail_full/5ae412d3a320fc1f5bb8bb25">关于娱乐健身的调查 </a></h4>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="item">
						<div class="col-md-2 testmonial-img">
							<img src="images/t4.png" class="img-responsive" alt=""/>
						</div>
						<div class="col-md-10 testmonial-text">
							<p><!-- Lorem ipsum dolor sit amet, offendit volutpat sea ex, at omnium scripta pro, at omnium scripta pro, ei mea oratio malorum forensibus. ei mea oratio malorum forensibus. Sed ei omnes laoreet posidonium ei mea oratio malorum forensibus. --></p>
							<!-- <h4><a href="#">Priston</a></h4> -->
							<h4><a href="https://www.wenjuan.com/lib_detail_full/5ae412d2a320fc1f5bb8bb23">华润微电子内刊问卷调查</a></h4>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
			</div>
		</div>
	</div>
		
		<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >网页模板</a></div>
		<!---- testmonials ---->
	</div>	
<!---content--->
	<%@include file="footer.jsp" %>
</body>
</html>