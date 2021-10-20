function check() {
	let name = document.getElementById("member_name");
	let email = document.getElementById("member_email");
	
	const regName = /^[가-힝a-z]{2,10}$/;
	const regEmail = /^[a-zA-Z0-9]([-_.]?[a-zA-Z0-9])*@[a-zA-Z0-9]([-_.]?[a-zA-Z0-9])*.[a-z-A-Z]{2,3}$/i;
	
	if(b.name.value == "") {
		alert("이름을 입력해주세요.");
		return b.name.focus();
	} else if(!check2(regName,name,"이름은 4~10자의 소문자와 영어와 한글만 입력 가능합니다.")) {
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