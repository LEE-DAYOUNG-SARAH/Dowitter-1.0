<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.green.dto.User" %>
<%
	User user = (User)session.getAttribute("loginUser");
%>
<!-- be included to login.jsp / join.jsp / modify.jsp / myFeed.jsp -->
<header>
	<section id="headerArea">
		<a href="goTimeline.do" class="logo">
			<img src="img/dowitter.png" alt="" />
		</a>
		<%
			if(user != null){
		%>
		<a href="logout.do" class="logout">·Î±×¾Æ¿ô</a>
		<%
			}
		%>
	</section>
</header>