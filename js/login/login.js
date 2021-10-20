function check() {
	
	if(b.member_id.value == "") {
		alert("아이디를 입력해주세요.");
		return b.member_id.focus();
	}
	
	if(b.member_pw.value == "") {
		alert("비밀번호를 입력해주세요.");
		return b.member_pw.focus();
	} 	
	b.submit();
}