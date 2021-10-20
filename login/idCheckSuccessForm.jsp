<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String checkId = request.getParameter("checkid");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 검사</title>
<link rel="stylesheet" type="text/css" href="<%request.getContextPath(); %>css/login/joinCheckForm.css">
<script type="text/javascript">
function result() {
	//부모창 opener
	var checkid = document.getElementById("checkID").value;
	opener.document.m.id.value=checkid;
	
	window.close();
}
</script>
</head>
<body>
	<section id="section">
        <div class="form">
			<h2>아이디 중복 체크</h2>
			<p>사용할수 있는 <%=checkId %> 입니다.</p>
			<input type="hidden" name="checkcId" id="checkID" value="<%=checkId%>">
			<input type="button" value="아이디 선택" onclick="result()">
	        </div>
    </section>
</body>
</html>