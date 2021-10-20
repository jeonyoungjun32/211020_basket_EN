<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
    <!-- article -->
     <article id="article" class="article">
        <div id="scoll_article" class="img_box">
            <!--이벤트 이미지 등록-->
            <!-- img 사이즈 기준 : 1280 x 720 jpg class="slide" 설정-->
            <img src="img/eventImg/slide-1.jpg" alt="" class="slide"/>
            <img src="img/eventImg/slide-2.jpg" alt="" class="slide"/>
            <img src="img/eventImg/slide-3.jpg" alt="" class="slide"/>
        </div>
        <div class="bottom_button">
        </div>
        <div class="opacity_top"></div>
        <div class="opacity_bottom"></div>
    </article>
    
    <%
    if(application.getAttribute("Counter") != null) {
    	String strCount = String.valueOf(application.getAttribute("Counter"));
    	int counter = Integer.parseInt(strCount) +1;
    	application.setAttribute("Counter", counter);
    } else {
    	application.setAttribute("Counter", 1);
    }
    
    ArrayList<MemberOrderRank> fiveOrderList = (ArrayList<MemberOrderRank>)request.getAttribute("fiveOrderList");
    %>
    <!-- section -->
    <section id="icecreamRank">
        <h2 class="icecreamTitle">weekly <span>icecream</span> 5th!</h2>
        <div class="iceRankBox">
        <%if (fiveOrderList != null) { %>
        <% int i =1;
        for(MemberOrderRank fiveList : fiveOrderList) { %>
            <div data-aos="fade-up" data-aos-duration="1000" class="icecreamrank">
            	<div class="iceColor"></div>
                <a href="icecreamIngredientList.bk?serial_code=<%=fiveList.getSerial_code()%>"><img src="img/icecream/<%=fiveList.getSerial_code() %>.png" alt="con" class="ice"></a>
                <div class="contextBox">
                	<p class="iceName"><%=fiveList.getName() %></p>
                	<p class="iceRanking"><%=i++ %>위<p>
                </div>
            </div>
           <%} %>
           <%} %>
        </div>
        <div class="sectionConnet"></div>
    </section>
    <script type="text/javascript">
    /* 타이머 */
    setInterval("dpTime()",1000);
    function dpTime(){
    	var now = new Date();
    	var hours = now.getHours();
    	var minutes = now.getMinutes();
    	var seconds = now.getSeconds(); 
    	
    	if (hours > 12) { 
    		hours -= 12;
    		ampm = "오후 ";
    	} else {
    		ampm = "오전 ";
    	} 
    	
    	if (hours < 10) {
    		hours = "0" + hours;
    	} 
    	
    	if (minutes < 10) { 
    		minutes = "0" + minutes;
    	}
    	
    	 if (seconds < 10) {
    		seconds = "0" + seconds;
    	}
    	
    	document.getElementById("Time").innerHTML = ampm + hours + ":" + minutes + ":" + seconds;
    }
    </script>
    <section id="etcBox">
    	<div class="etcbox_contect">
	    	<div class="etcbox_count">
	    		<p class="etcViewCount">총 방문자 수 : <%=application.getAttribute("Counter") %></p>
	    		<span id="Time"></span>
	    	</div>
    	</div>
    </section>

 <%@ include file="footer.jsp" %>