$(document).ready(function(){
	$('#OrderMy_ViewCount').on('click',function(){
		if($(this).val()=="5") {
		$(this).attr("selected","selected")
		location="memberOrderPro.bg?view_Count=5";
		} else if ($(this).val()=="10") {
		$(this).attr("selected","selected")
		location="memberOrderPro.bg?view_Count=10";
		} else if ($(this).val()=="20") {
		$(this).attr("selected","selected")
		location="memberOrderPro.bg?view_Count=20";
		} else if ($(this).val()=="30") {
		$(this).attr("selected","selected")
		location="memberOrderPro.bg?view_Count=30";
		}
	});
});

function orderCancel() {
	if(confirm("주문을 취소하시겠습니까?")==true) {
		document.myOrder.submit();
	} else return;
}
