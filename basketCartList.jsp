<%@page import="vo.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
ArrayList<Cart> CartList = (ArrayList<Cart>) session.getAttribute("cartList");
int totalMoney =(int) request.getAttribute("totalMoney");/* 총 금액 */
String remove = request.getParameter("remove");/* 삭제 */
%>

<script type="text/javascript">
function remove() {
	   if(confirm("삭제하시겠습니까?") == true) {
	      alert("삭제가 되었습니다.");
	      document.remove.submit();
	   } else return;
	}
</script>

<%@include file="header.jsp"%>

<section id="basketSection">
	<p class="basket_title"><span><%=member.getName() %></span>님의 장바구니</p>
	<table id="basketTable">
		<tr>
			<th>번호</th>
			<th>상품 번호</th>
			<th>상품 이름</th>
			<th>상품 종류</th>
			<th>상품 수량</th>
			<th>상품 가격</th>
			<th colspan="2">기타 옵션</th>
		</tr>
		<%if (CartList.isEmpty()) { %>
		<tr>
			<td colspan="8">장바구니가 비었습니다.</td>
		</tr>
	</table>
		<%} else {%>
		<%int j = 1;
		for (int i = 0; i < CartList.size(); i++) {
		%>
		<tr>
			<td><%=j++%></td>
			<%if (CartList.get(i).getKinds().equalsIgnoreCase("1")) {%>
			<td>
				<a href="basketCartList.bk">
					<img src="img/iceCake/<%=CartList.get(i).getSerial_code() %>.png" alt="아이스케이크 사진">
				</a>
			</td>
			<%} else if (CartList.get(i).getKinds().equalsIgnoreCase("2")) {%>
			<td>
				<a href="basketCartList.bk">
					<img src="img/beverage/<%=CartList.get(i).getSerial_code() %>.png" alt="음료 사진">
				</a>
			</td>
			<%} else if (CartList.get(i).getKinds().equalsIgnoreCase("3")) {%>
			<td>
				<a href="basketCartList.bk">
					<img src="img/coffee/<%=CartList.get(i).getSerial_code() %>.png" alt="커피 사진">
				</a>
			</td>
			<%} else if (CartList.get(i).getKinds().equalsIgnoreCase("4")) {%>
			<td>
				<a href="basketCartList.bk">
					<img src="img/dessert/<%=CartList.get(i).getSerial_code() %>.png" alt="디저트 사진">
				</a>
			</td>
			<%} else if (CartList.get(i).getKinds().equalsIgnoreCase("5")) {%>
			<td>
				<a href="basketCartList.bk">
					<img src="img/icecream/<%=CartList.get(i).getSerial_code() %>.png" alt="아이스크림 사진">
				</a>
			</td>
			<%} %>
			<td><%=CartList.get(i).getName()%></td>
			<%if (CartList.get(i).getKinds().equalsIgnoreCase("1")) {%>
			<td>케이크</td>
			<%} else if (CartList.get(i).getKinds().equalsIgnoreCase("2")) {%>
			<td>음료</td>
			<%} else if (CartList.get(i).getKinds().equalsIgnoreCase("3")) {%>
			<td>커피</td>
			<%} else if (CartList.get(i).getKinds().equalsIgnoreCase("4")) {%>
			<td>디저트</td>
			<%} else if (CartList.get(i).getKinds().equalsIgnoreCase("5")) {%>
			<td>아이스크림</td>
			<%}	%>
			<td><%=CartList.get(i).getCount()%></td>
			<td><%=CartList.get(i).getPrice()%></td>
			<form action="basketCartRemove.bk" method="post">
				<td>
					<input type="hidden" name="serial_code" value="<%=CartList.get(i).getSerial_code()%>"> 
					<input type="submit" value="삭제" onclick="remove(); return false" >
				</td>
			</form>
			<%if (CartList.get(i).getKinds().equalsIgnoreCase("1")) { %>
			<td><a href="iceCakeList.bk" class="basketLink">쇼핑 계속하기</a></td>
			<%} else if (CartList.get(i).getKinds().equalsIgnoreCase("2")) {%>
			<td><a href="beverageList.bk" class="basketLink">쇼핑 계속하기</a></td>
			<%} else if (CartList.get(i).getKinds().equalsIgnoreCase("3")) {%>
			<td><a href="coffeeList.bk" class="basketLink">쇼핑 계속하기</a></td>
			<%} else if (CartList.get(i).getKinds().equalsIgnoreCase("4")) {%>
			<td><a href="dessertList.bk" class="basketLink">쇼핑 계속하기</a></td>
			<%} else if (CartList.get(i).getKinds().equalsIgnoreCase("5")) {%>
			<td><a href="icecreamList.bk" class="basketLink">쇼핑 계속하기</a></td>
			<%}%>
		</tr>
		<%}%>
	</table>
	<table id="orderMoney">
		<tr>
			<th>총 상품 금액</th>
			<td class="totalMoney"><p><%=totalMoney%>$</p></td>
			<td rowspan="2" class="orderMoneylink">
				<input type="button" value="배송확인" onclick="javascript:location='notPage.jsp'">
			</td>
			<td rowspan="2" class="orderMoneylink">
			<input type="button" value="주문하기" onclick="javascript:location='orderResult.bk'">
			</td>
		</tr>
		<tr>
			<td align="center">배송</td>
			<td>
				<p>배송비는 <u>5,000$</u></p>
				<p>Seoul City, 12345,대한민국에 배송합니다.</p>
			</td>
		</tr>
	</table>
	<%} %>
</section>
<div class="footerColor"></div>

<%@ include file="footer.jsp" %>
