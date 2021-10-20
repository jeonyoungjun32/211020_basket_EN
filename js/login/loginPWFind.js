function check() {
	let id = document.getElementById("member_id");
	let email = document.getElementById("member_email");
	
	const regIDPW = /^[a-zA-Z0-9]{4,20}$/;
	const regEmail = /^[a-zA-Z0-9]([-_.]?[a-zA-Z0-9])*@[a-zA-Z0-9]([-_.]?[a-zA-Z0-9])*.[a-z-A-Z]{2,3}$/i;
	
	if(b.id.value == "") {
		alert("아이디를 입력해주세요.");
		return b.id.focus();
	} else if(!check2(regIDPW,id,"아이디는 4~20자의 대소문자 영어와 숫자로만 입력 가능합니다.")) {
		return false;
	}
	
	if(b.email.value == "") {
		alert("이메일을 입력해주세요.");
		return b.email.focus();
	} else if(!check2(regEmail,email,"이메일 형식에 맞게 작성해주세요.(ex 123@123.com)")) {
		return false;
	}
	
	b.submit();
}
function check2(re,id,message) {
	if(re.test(id.value)) {return true;}
	alert(message);
	id.select();
	return false;
}