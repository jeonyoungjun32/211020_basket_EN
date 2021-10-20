function check() {
	let id = document.getElementById("member_id");
	let pw = document.getElementById("member_pw");
	
	const regIDPW = /^[a-zA-Z0-9]{4,20}$/;
	
	if(b.id.value == "") {
		alert("아이디를 입력해주세요.");
		return b.id.focus();
	} else if(!check2(regIDPW,id,"아이디는 4~20자의 대소문자 영어와 숫자로만 입력 가능합니다.")) {
		return false;
	}
	
	if(b.pw.value == "") {
		alert("비밀번호를 입력해주세요.");
		return b.pw.focus();
	}  else if(!check2(regIDPW,pw,"비밀번호는 4~20자의 소문자 영어와 숫자로만 입력 가능합니다.")) {
		return false;
	}
	
	if(b.pw1.value == "") {
		alert("비밀번호를 한번 더 입력해주세요.");
		return b.pw1.focus();
	} else if (b.pw.value != b.pw1.value) {
		b.member_pw1.value ="";
		return b.pw1.focus();
	}
	b.submit();
}
function check2(re,id,message) {
	if(re.test(id.value)) {return true;}
	alert(message);
	id.select();
	return false;
}