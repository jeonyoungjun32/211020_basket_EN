function memberCheckAll() {
	for (i = 0; i < form.memberCheck.length; i++) {
		form.memberCheck[i].checked = true;
	}
}

function unMemberCheckAll() {
	for (i = 0; i < form.memberCheck.length; i++) {
		form.memberCheck[i].checked = false;
	}
}
$(document).ready(function() {
	$('#view_Count').on('click', function() {
		if ($(this).val() == "5") {
			$(this).attr("selected", "selected")
			location = "adminMemberListPro.bg?view_Count=5";
		} else if ($(this).val() == "10") {
			$(this).attr("selected", "selected")
			location = "adminMemberListPro.bg?view_Count=10";
		} else if ($(this).val() == "25") {
			$(this).attr("selected", "selected")
			location = "adminMemberListPro.bg?view_Count=25";
		} else if ($(this).val() == "50") {
			$(this).attr("selected", "selected")
			location = "adminMemberListPro.bg?view_Count=50";
		}
	});
});