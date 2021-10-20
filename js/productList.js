function productCheckAll() {
	for (i = 0; i < p_form.productCheck.length; i++) {
		p_form.productCheck[i].checked = true;
	}
}

function unProductCheckAll() {
	for (i = 0; i < p_form.productCheck.length; i++) {
		p_form.productCheck[i].checked = false;
	}
}
$(document).ready(function() {
	$('#Product_Select').on('click', function() {
		if ($(this).val() == "all") {
			$(this).attr("selected", "selected")
			location = "adminProductListForm.bg?Product_Select=all";
		} else if ($(this).val() == "icecream") {
			$(this).attr("selected", "selected")
			location = "adminProductListForm.bg?Product_Select=icecream";
		} else if ($(this).val() == "icecake") {
			$(this).attr("selected", "selected")
			location = "adminProductListForm.bg?Product_Select=icecake";
		} else if ($(this).val() == "beverage") {
			$(this).attr("selected", "selected")
			location = "adminProductListForm.bg?Product_Select=beverage";
		} else if ($(this).val() == "coffee") {
			$(this).attr("selected", "selected")
			location = "adminProductListForm.bg?Product_Select=coffee";
		} else if ($(this).val() == "dessert") {
			$(this).attr("selected", "selected")
			location = "adminProductListForm.bg?Product_Select=dessert";
		}
	});
});