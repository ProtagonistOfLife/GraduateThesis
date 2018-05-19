<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<base href=<%=request.getContextPath()+"/" %>>
	<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
	<title>�û�ע��</title>
	<link rel="stylesheet" href="css/framedesign.css" type="text/css" />
	<link rel="stylesheet" href="css/fontdesign.css" type="text/css">
	<script type="text/javascript" src="js/verify.js" charset="gbk"></script>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js" charset="gbk"></script>
	<!-- ע���ύ��ť������ -->
	<script type="text/javascript">
	//���,���ڱ��������֤�Ƿ�ɹ��ı��
		var veryflag = false;
	//����ʱ��ʱΪtrue
		//var veryflag = true;
		
		$(function(){
	//		�ύ��ť�ĵ���¼�
			$("#submits").click(function(){
				if(veryflag){
					$("#fm_regist").submit();
				}
			});
		});
	</script>
</head>
<body>
	<c:set var="englishname" value="User Registration Information Form" scope="request"></c:set>
	<c:set var="name" value="�û�ע����Ϣ��" scope="request"></c:set>
	<%@include file="top.jsp" %>
	<div class="maxwidth">
		<div class="formdiv">
			<form action="regist" method="post" id="fm_regist">
				<span class="filedname">�û�����</span><input class="textfiled" maxlength="9" type="text" name="nickname" size="10" placeholder="����Ψһ�û���">
				<span id="namewarn"></span>
				<br>
				<span class="filedname">�Ա�</span>
				<input type="radio" name="sex" value="��" id="m" checked><label for="m">��</label>
				<input type="radio" name="sex" value="Ů" id="f"><label for="f">Ů</label>
				<br>
				<span class="filedname">�������ڣ�</span>
				<select id="selectyear" name="year" onchange="changed('selectyear')">
				</select>��<!-- ׼��ͨ��js��ʵ�� -->
				<select id="selectmonth" name="month" onchange="changed('selectmonth')"></select>��
				<select id="selectday" name="day"></select>��
				<br>
				<span class="filedname">���룺</span><input id="pwd" class="textfiled" maxlength="16" type="password" name="password" size="16" placeholder="������8~16λ����">
				<span id="pwdwarn"></span>
				<br>
				<span class="filedname">ȷ�����룺</span><input id="vpwd" class="textfiled" maxlength="16" type="password" size="16" placeholder="���������������">
				<span id="vpwdwarn"></span>
				<br>
				<span class="confirmspan" id="phonenum">
					<span class="filedname">�绰���룺</span><input class="textfiled" type="text" name="phonenum" id="phonenum_inp" size="15" placeholder="������绰����">
					<button id="bt_phone" onclick ="verified('phonenum')" type="button">��֤</button>
					<span id="phonewarn"></span>
				</span>
				<br>
				<span class="confirmspan" id="email">
					<span class="filedname">email:</span><input class="textfiled" type="text" name="email" id="email_inp" size="20" placeholder="������绰����">
					<button id="bt_email" onclick ="verified('email')" type="button">��֤</button>
					<span id="emailwarn"></span>
				</span>
				<br>
				<input class="submit" type="reset" value="����">
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="submits" class="submit" type="button" value="ע��"/>
			</form>
		</div>
	</div>
	<%@include file="foot.jsp" %>
</body>
</html>