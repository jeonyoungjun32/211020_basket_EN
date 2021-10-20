<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String getId = (String)request.getAttribute("id");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<link rel="stylesheet" type="text/css" href="<%request.getContextPath(); %>css/login/loginFind.css"/>
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
                    <h2>아이디 찾은 결과</h2>
                    <div class="inputBox">
                    <%if (getId != null) { %>
                    	<p class="forgetReuslt">찾는 아이디는 <%=getId %> 입니다.</p>
                    </div>
                    <p class="forget"><a href="index.bk">홈페이지</a></p>
                    <p class="forget"><a href="login.bk">로그인</a></p>
                    <p class="forget"><a href="loginFindPWForm.bk?id=<%=getId %>">비밀번호 찾기</a></p>
                    <% } else { %>
                    	<p class="forgetReuslt">찾을 아이디가 없습니다</p>
                    </div>
                    <p class="forget"><a href="iceCube.bg">홈페이지</a></p>
                    <p class="forget"><a href="login.bk">로그인</a></p>
                    <%} %>
            </div>
        </div>
    </section>
</body>
</html>