/*adminOrderPage 뷰 페이지 처리 */
$(document).ready(function(){
	var searchID = $('#searchID').val();
	$('#Order_myViewCount').on('click',function(){
		if($(this).val()=="5") {
		$(this).attr("selected","selected")
		location="adminOneMemberOrderPro.bg?searchID="+searchID+"&view_Count=5";
		} else if ($(this).val()=="10") {
		$(this).attr("selected","selected")
		location="adminOneMemberOrderPro.bg?searchID="+searchID+"&view_Count=10";
		} else if ($(this).val()=="20") {
		$(this).attr("selected","selected")
		location="adminOneMemberOrderPro.bg?searchID="+searchID+"&view_Count=20";
		} else if ($(this).val()=="30") {
		$(this).attr("selected","selected")
		location="adminOneMemberOrderPro.bg?searchID="+searchID+"&view_Count=30";
		}
	});
});

function adminorderCancel() {
	if(confirm("주문을 취소하시겠습니까?")==true) {
		document.memberOrder.submit();
	} else return;
}
