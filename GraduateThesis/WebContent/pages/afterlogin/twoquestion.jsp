<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
 <script  type="text/javascript">
 	function dosubmit(){
 		var arr = $("#overed span[name=choose]");
 		console.log(arr);
 		console.log(arr.eq(0).text());
 		var question = arr.eq(0).text();
 		var chooses = "";
 		for(var i = 1;i < arr.length;i++){
 			chooses += arr.eq(i).text()+";";
 		}
 		$.ajax({
 			type:"post",
 			url:"subquestion",
 			data:{"question":encodeURI(question),"chooses":encodeURI(chooses)},
 			success:function(data){
 				if(data){
 					var questions = $("#questions");
 					var question = $("#overed div");
 					questions.append(question);
 					$("changefiled").show();
					$("#addques").show();
					$("#tq").hide();
					$("#choose").hide();
					$("#question").show();
					$("#outer").hide();
					chid = 0;
 				}
 			},
 			dataType:"text"
 		});
 		/* $.ajax({
			type:"post",
			url:"subquestion",
			data:{"question":question,"chooses":chooses},
			success:function(data){
				//当服务端返回结果为1时表示验证成功
				alert(date);
				if(data == 1){
					$("changefiled").show();
					$("#addques").show();
					$("#tq").hide();
				}
			},
			dataType:"text"
		}); */
 	}
 </script>
<div id="tq" style="min-height: 500px;display: none;padding-left: 90px;">
</div>