<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 검사</title>
<script type="text/javascript" src="<%request.getContextPath(); %>js/login/joinCheckForm.js"></script>
<link rel="stylesheet" type="text/css" href="<%request.getContextPath(); %>css/login/joinCheckForm.css">
</head>
<body>
	<section id="section">
        <div class="form">
            <h2>아이디 중복 체크</h2>
            <form action="loginIdCheckPro.bk" name="m" method="post" class="loginIdCheckBox">
                <div class="idCheckBox">
                <input type="text" name ="checkid" id="check_id" value ="" placeholder="id를 입력해주세요">
                </div>
                <div class="inputBox">
                    <input type="submit" value = "check" onclick="check(); return false">
                    <input type="button" value = "닫기" onclick="window.close()">
                </div>
            </form>
        </div>
    </section>
</body>
</html>