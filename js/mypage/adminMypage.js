/*물건 정규식 */
function productInsert() {
	let name = document.getElementById("name");
	let kcal = document.getElementById("kcal");
	let allergy = document.getElementById("allergy");
	let price = document.getElementById("price");

	const regProductInt = /^[0-9]{0,}$/;
	const regProductName = /^[a-zA-Z가-힝0-9\s]{0,}$/i;
	const regAllergyName = /^[a-zA-Z가-힝0-9\s]([,]?[a-zA-Z가-힝0-9\s]){0,}$/i;

	if (product.name.value == "") {
		alert("상품 이름를 입력해주세요.");
		return product.name.focus();
	} else if (!check2(regProductName, name, "특수문자는 사용이 안됩니다")) {
		return false;
	}

	if (product.kcal.value == "") {
		alert("칼로리를 입력해주세요.");
		return product.kcal.focus();
	} else if (!check2(regProductInt, kcal, "숫자만 사용가능합니다")) {
		return false;
	}

	if (product.allergy.value == "") {
		alert("알레르기 종류를 입력해주세요.");
		return product.allergy.focus();
	} else if (!check2(regAllergyName, allergy, "문자로 입력해주세요.")) {
		return false;
	}

	if (product.price.value == "") {
		alert("가격을 입력해주세요.");
		return product.price.focus();
	} else if (!check2(regProductInt, price, "숫자만 사용가능합니다")) {
		return false;
	}

	if (product.choice.value == "") {
		alert("물건 등록 종류를 선택해주세요.");
		return;
	}

	product.submit();
}

/*상품 수정 정규식 및 유효성 검사 */
function productUpdate() {
	
	let name = document.getElementById("name");
	let kcal = document.getElementById("kcal");
	let allergy = document.getElementById("allergy");
	let price = document.getElementById("price");
	let file = document.getElementById("fileImg").files[0].name;

	const regFileForm = /(.*?)\.(png)$/;
	const regProductInt = /^[0-9]{0,}$/;
	const regProductName = /^[a-zA-Z가-힝0-9\s]{0,}$/i;
	const regAllergyName = /^[a-zA-Z가-힝0-9\s]([,]?[a-zA-Z가-힝0-9\s]){0,}$/i;

	if (productupdate.name.value == "") {
		alert("상품 이름를 입력해주세요.");
		return productupdate.name.focus();
	} else if (!check2(regProductName, name, "특수문자는 사용이 안됩니다")) {
		return false;
	}

	if (productupdate.kcal.value == "") {
		alert("칼로리를 입력해주세요.");
		return productupdate.kcal.focus();
	} else if (!check2(regProductInt, kcal, "숫자만 사용가능합니다")) {
		return false;
	}

	if (productupdate.allergy.value == "") {
		alert("알레르기 종류를 입력해주세요.");
		return productupdate.allergy.focus();
	} else if (!check2(regAllergyName, allergy, "문자로 입력해주세요.")) {
		return false;
	}

	if (productupdate.price.value == "") {
		alert("가격을 입력해주세요.");
		return productupdate.price.focus();
	} else if (!check2(regProductInt, price, "숫자만 사용가능합니다")) {
		return false;
	}
	
	let codeValue = document.getElementById("serial_code").value;	
	
	if (productupdate.fileImg.value == "") {
		alert("상품 이미지를 등록해주세요.");
		if (confirm("상품 이미지가 없어도 진행하시겠습니까?")) {
			productupdate.submit();
		} else {
			return;
		}
	} else if(productupdate.fileImg.value != "") {
		var indexdot = file.indexOf(".");
		/*alert(file.substr(0,indexdot));*/
		if (file.substr(0,indexdot) != codeValue) {
			alert("상품코드랑 동일하게 이미지 이름을 설정해주세요.");
			alert("png(소문자)확장자 파일만 가능합니다");
			return false;
		} else {
			productupdate.submit();
		}
	} /*else if (!check2(regFileForm, file, "png(소문자)확장자 파일만 가능합니다")) {
		return false;
	}*/
	
}

function productRewrit() {
	if (confirm("다시 작성하시겠습니까?")) {
		product.reset();
	}
	return;
}

function IORewrit() {
	if (confirm("다시 작성하시겠습니까?")) {
		IOinsert.reset();
	}
	return;
}

/*정규식 확인 */
function check2(re, id, message) {
	if (re.test(id.value)) { return true; }
	alert(message);
	id.select();
	return false;
}

function adminleaveConfirm() {
	var adminRealPw = document.getElementById("pw").value;
	var deleteMemberID = document.getElementById("id").value;
	var adminpw = prompt("관리자 패스워드를 입력하세요","");
	if(adminpw == adminRealPw) {
		if(confirm("정말 탈퇴 하시겠습니까? 탈퇴시 보유중인 돈과 포인트는 소멸됩니다.")) {
			location="adminMemberLeavePro.bg?id="+deleteMemberID;
		} else {
			return false;
		}
	} else {
		alert("비밀빈호가 틀립니다");
		return false;
	}
	return false;
}

function adminListleaveConfirm() {
	var adminRealPw = document.getElementById("pw").value;
	var adminpw = prompt("관리자 패스워드를 입력하세요","");
	if(adminpw == adminRealPw) {
		if(confirm("정말 탈퇴 하시겠습니까? 탈퇴시 보유중인 돈과 포인트는 소멸됩니다.")) {
			form.submit();
		} else {
			return false;
		}
	} else {
		alert("비밀빈호가 틀립니다");
		return false;
	}
	return false;
}
