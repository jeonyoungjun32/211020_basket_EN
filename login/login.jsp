<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Cookie[] saveID = request.getCookies();
String id = "";
if(saveID != null) {
	for(Cookie saveid : saveID) {
		if(saveid.getName().equals("saveid")) {
			id =saveid.getValue();
		}
	}
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
 <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<link rel="stylesheet" type="text/css" href="<%request.getContextPath(); %>css/login/login.css"/>
<script type="text/javascript" src="<%request.getContextPath(); %>js/login/login.js"></script>
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
                    <h2>로그인 화면</h2>
                    <form action="loginPro.bk" name="b" method="post">
                        <div class="inputBox">
                            <input type="text" name="id" id="member_id" value="<%=id %>" maxlength="20" placeholder="user Id">
                        </div>
                        <div class="inputBox">
                            <input type="password" name="pw" id="member_pw" value="" maxlength="30" placeholder="user Password">
                        </div>
                        <div class="inputBox">
                            <input type="submit" value="Login" onclick="check(); return false">
                        </div>
                        <div class="inputBox">
                            <label class="inputBoxRemember">
	                           	remember ID <input type="checkbox" name="saveID" value="true">
                            </label>
                        </div>
                        <div class="linkBox">
	                        <p class="forget">아이디를 잊었습니까? <a href="loginFindIDForm.bk">아이디 찾기</a></p>
	                        <p class="forget">비밀번호를 잊었습니까? <a href="loginFindPWForm.bk">비밀번호 찾기</a></p>
	                        <p class="forget">회원이 아니면 회원가입해주세요! <a href="loginJoinForm.bk">회원가입</a></p>
	                        <p class="forget"><a href="iceCube.bg">홈페이지</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>