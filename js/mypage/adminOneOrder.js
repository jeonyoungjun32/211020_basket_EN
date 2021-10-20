/*adminOrderPage 뷰 페이지 처리 */
$(document).ready(function(){
	$('#Order_ViewCount').on('click',function(){
		if($(this).val()=="5") {
		$(this).attr("selected","selected")
		location="adminOrderPro.bg?view_Count=5";
		} else if ($(this).val()=="10") {
		$(this).attr("selected","selected")
		location="adminOrderPro.bg?view_Count=10";
		} else if ($(this).val()=="20") {
		$(this).attr("selected","selected")
		location="adminOrderPro.bg?view_Count=20";
		} else if ($(this).val()=="30") {
		$(this).attr("selected","selected")
		location="adminOrderPro.bg?view_Count=30";
		}
	});
});

