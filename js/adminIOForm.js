$(document).ready(function(){
	$('.table_delete').on('click',function(){
		$(this).closest('#Product_table').remove();
	})
});