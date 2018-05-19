<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
function fun(){
	$.ajax({
		type:"get",
		url:"/GraduateThesis/subquestion",
		data:{geturl:"ok"},
		success:function(data){
			alert("请复制调查链接:"+data);
		},
		dataType:"text"
	});
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<button onclick="fun()">quedibg</button>
</body>
</html>