
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<link rel="stylesheet" type="text/css" href="<%request.getContextPath(); %>css/login/joinForm.css"/>
<!-- 유효성 검사 자바스크립트 -->
<script type="text/javascript" src="<%request.getContextPath(); %>js/login/joinForm.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
function idCheckWindow() {
	window.open("loginIdCheck.bk","아이디 중복 체크","width=500px, height=200px, top=300, left=700");
}
function kakaopost() {
    new daum.Postcode({
        oncomplete: function(data) {
           document.querySelector("#member_address").value = data.zonecode;
           document.querySelector("#address").value =  data.address
        }
    }).open();
}
</script>
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
        <div class="square" style="--i:5;"></div>
        <div class="square" style="--i:6;"></div>
        <div class="container">
            <div class="form">
                <h2>회원 가입 화면</h2>
                <form action="loginjoinPro.bk" name="m" method="post">
                    <div class="inputBox">
                        <input type="text" name="id" id="member_id" maxlength="20" readonly="readonly" placeholder="ID를 입력해주세요">
                        <input type="button" value="check" onclick="idCheckWindow()">
                    </div>
                    <div class="inputBox">
                        <input type="password" name="pw" id="member_pw" value="" maxlength="30" placeholder="비밀번호를 입력해주세요">
                    </div>
                    <div class="inputBox">
                        <input type="password" name="pw1" value="" maxlength="30" placeholder="비밀번호를 다시 입력해주세요">
                    </div>
                    <div class="inputBox">
                        <input type="text" name="name" id="member_name" value="" maxlength="10" placeholder="이름을 입력해주세요">
                    </div>
                    <div class="inputBox">
                       <input type="text" name="address_number" id="member_address" value="" maxlength="6" readonly="readonly" placeholder="우편번호를 입력해주세요">
                       <input type="button" value="검색" onclick="kakaopost()">
                       <input type="text" name="address" id="address" value="" readonly="readonly" placeholder="주소를 입력해주세요">
                       <input type="text" name="address_contents" value="" placeholder="상세주소를 입력해주세요">
                    </div>
                    <div class="inputBox">
                        <input type="text" name="email" id="member_email" value="" placeholder="이메일을 입력해주세요">
                    </div>
                    <div class="inputBox">
                        <input type="date" name="birth" value="" placeholder="생일을 입력해주세요">
                    </div>
                    <div class="inputBox">
                        <label><input type="radio" name="gender" value="M">남</label>
                        <label><input type="radio" name="gender" value="F">여</label>
                    </div>
                    <div class="inputBox">
                        <input type="submit" value="Join" onclick="check(); return false">
                        <input type="button" value="reset" onclick="rewrit(); return false">
                    </div>
                    <p class="forget"><a href="iceCube.bg">홈페이지</a></p>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>