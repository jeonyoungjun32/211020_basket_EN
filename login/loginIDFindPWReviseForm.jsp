<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String getId = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<link rel="stylesheet" type="text/css" href="<%request.getContextPath(); %>css/login/loginFind.css"/>
<script type="text/javascript" src="<%request.getContextPath(); %>js/login/loginIDFinewPWRevise.js"></script>
</head>
<body>
   <section>
        <!--배경 이미지 만들기위한 박스-->
        <div class="color"></div>
        <div class="color"></div>
        <div class="color"></div>
        <div class="color"></div>
        <div class="color"></div>
        <div class="color"></div>
        <div class="box">
            <!--유동 박스-->
            <div class="square" style="--i:0;"></div>
            <div class="square" style="--i:1;"></div>
            <div class="square" style="--i:2;"></div>
            <div class="square" style="--i:3;"></div>
            <div class="square" style="--i:4;"></div>
            <div class="container">
                <div class="form">
                    <h2>비밀번호 변경</h2>
                    <form action="loginIDFindPWRevisePro.bk" name="b" method="post">
                        <div class="inputBox">
                       		<input type="text" name="id" id="member_id" value="" placeholder="아이디을 입력해주세요">
                        </div>
                        <div class="inputBox">
	                        <input type="password" name="pw" id="member_pw" value="" maxlength="30" placeholder="비밀번호를 입력해주세요">
	                    </div>
	                    <div class="inputBox">
	                        <input type="password" name="pw1" value="" maxlength="30" placeholder="비밀번호를 다시 입력해주세요">
	                    </div>
                        <div class="inputBox">
                            <input type="submit" value="find" onclick="check(); return false">
                        </div>
                        <p class="forget"><a href="iceCube.bg">홈페이지</a></p>
                        <p class="forget"><a href="login.bk">로그인</a></p>
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>