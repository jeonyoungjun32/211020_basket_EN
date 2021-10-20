function kakaopost() {
    new daum.Postcode({
        oncomplete: function(data) {
           document.querySelector("#member_address").value = data.zonecode;
           document.querySelector("#address").value = data.address
        }
    }).open();
}

/*개인 정보 수정 정규식 */
function check() {
	let id = document.getElementById("member_id");
	let pw = document.getElementById("member_pw");
	let name = document.getElementById("member_name");
	let address = document.getElementById("member_address");
	let email = document.getElementById("member_email");
	
	const regIDPW = /^[a-z0-9]{4,20}$/;
	const regName = /^[가-힝a-z]{2,10}$/;
	const regAdr = /^[0-9]{0,6}$/;
	const regEmail = /^[a-zA-Z0-9]([-_.]?[a-zA-Z0-9])*@[a-zA-Z0-9]([-_.]?[a-zA-Z0-9])*.[a-z-A-Z]{2,3}$/i;
	
	if(m.id.value == "") {
		alert("아이디를 입력해주세요.");
		return m.id.focus();
	} else if(!check2(regIDPW,id,"아이디는 4~20자의 소문자 영어와 숫자로만 입력 가능합니다.")) {
		return false;
	}
	
	if(m.pw.value == "") {
		alert("비밀번호를 입력해주세요.");
		return m.pw.focus();
	}  else if(!check2(regIDPW,pw,"비밀번호는 4~20자의 소문자 영어와 숫자로만 입력 가능합니다.")) {
		return false;
	}
	
	if(m.pw1.value == "") {
		alert("비밀번호를 한번 더 입력해주세요.");
		return m.pw1.focus();
	} else if (m.pw.value != m.pw1.value) {
		alert("비밀번호가 일치하지않습니다");
		m.pw1.value ="";
		return m.pw1.focus();
	}
	
	if(m.name.value == "") {
		alert("이름을 입력해주세요.");
		return m.name.focus();
	} else if(!check2(regName,name,"이름은 4~10자의 소문자와 영어와 한글만 입력 가능합니다.")) {
		return false;
	}
	
	if(m.address_number.value == "") {
		alert("우편번호를 입력해주세요.");
		return m.address_number.focus();
	} else if(!check2(regAdr,address,"우편번호는 숫자만 입력가능합니다.")) {
		return false;
	}
	
	if(m.address.value == "") {
		alert("주소를 입력해주세요.");
		return m.address.focus();
	}
	if(m.address_contents.value == "") {
		alert("상세주소를 입력해주세요.");
		return m.address_contents.focus();
	}
	if(m.email.value == "") {
		alert("이메일을 입력해주세요.");
		return m.email.focus();
	} else if(!check2(regEmail,email,"이메일 형식에 맞게 작성해주세요.(ex 123@123.com)")) {
		return false;
	}
	
	if(m.birth.value == "") {
		alert("생일을 선택해주세요.");
		return false;
	}
	if(m.gender[0].checked == false && m.gender[1].checked == false) {
		alert("성별을 체크해주세요.");
		return false;
	}
	
	m.submit();
}

/*돈 충전 정규식 */
function checkmoney() {
	
	let InputMoney = document.getElementById("InputMoney");
	
	const regMoney = /^[0-9]{0,7}$/;
	
	if(money.money.value == "") {
		alert("충전할 금액을 입력해주세요");
		return money.money.focus();
	} else if(!check2(regMoney,InputMoney,"최대 100만원까지 충전가능합니다.")) {
		return false;
	}
	
	money.submit();
}

function check2(re,id,message) {
	if(re.test(id.value)) {return true;}
	alert(message);
	id.select();
	return false;
}

function rewrit() {
	if(confirm("다시 작성하시겠습니까?")) {
		m.reset();
	}
	return;
}

function leaveConfirm() {
	var realPw = document.getElementById("pw").value;
	var pw = prompt("패스워드를 입력하세요","");
	if(pw == realPw) {
		if(confirm("정말 탈퇴 하시겠습니까? 탈퇴시 보유중인 돈과 포인트는 소멸됩니다.")) {
			location="memberLeavePro.bg";
		} else {
			return false;
		}
	} else {
		alert("비밀빈호가 틀립니다");
		return false;
	}
	return false;
}
