function check() {
	let id = document.getElementById("check_id");
	
	const regIDPW = /^[a-z0-9]{4,20}$/;
	
	if(m.checkid.value == "") {
		alert("아이디를 입력해주세요.");
		return m.checkid.focus();
	} else if(!check2(regIDPW,id,"4~20자의 소문자 영어와 숫자 입력가능합니다")) {
		return false;
	}
	
	m.submit();
}
function check2(re,id,message) {
	if(re.test(id.value)) {return true;}
	alert(message);
	id.select();
	return false;
}
