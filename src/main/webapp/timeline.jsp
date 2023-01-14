<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="jspf/checkLogin.jspf" %>
<%@ page import="kr.ac.green.dto.Doc" %>
<!-- head.jsp -->
<jsp:include page="head.jsp" />
<%
	Doc[] list = (Doc[])request.getAttribute("list");
	Doc modifyDoc = null;
%>
<body>
	<section id="timelineHeader">
		<div class="safeArea">
			<a href="goTimeline.do" class="logo">
				<img src="img/dowitter.png" alt="" />
			</a>
			<div class="searchArea">
				<div class="inputArea">
					<label for="">@</label>
					<input type="text" id="search" placeholder="ID" />
					<ul class="selectUserArea">
						<li class="searchedUser">
							<a href="userID">
								@userA
							</a>
						</li>
						<li class="searchedUser">
							<a href="userID">
								@userB
							</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="userArea">
				
				<!-- 로그인 상태 -->
				<div class="loggedInNow">
					<a href="goMyFeed.do">@<%= user.getU_id() %></a>
					<a href="logout.do">로그아웃</a>
				</div>
				
				<!-- 로그아웃상태 -->
				<!-- <div class="loggedOUtNow">
					<a href="goLogin.do">로그인</a>
					<a href="goJoin.do">회원가입</a>
				</div> -->
			</div>
		</div>
	</section>
	<div id="wrap">
		<section id="timelineBody">
			<div class="timeline">
				<form>
				<div class="writeFeed">
					<textarea name="d_content" id="" cols="30" rows="10" placeholder="아무말이나 적어보세요..!"></textarea>
					<div class="write" onclick="document.getElementById('writeButton').click()">
						글쓰기
						<input type="button" id="writeButton" onclick="doWhat(this.form, 'doWriteTimeline.do',true)" />
					</div>
				</div>
				</form>
				<div class="readFeeds">
					<ul class="feeds">
						<%
							if(list == null || list.length == 0){
							
							}else{
								for(int idx=0;idx<list.length;idx++){
						%>
						<li class="feed">
							<form name="<%= list[idx].getD_num()%>">
							<div class="feedTitle">
								<a class="feedId">@<%= list[idx].getU_id() %></a>
								<span class="feedDate"><%= list[idx].getD_date() %></span>
							</div>
							<div class="feedContent"><%= list[idx].getD_content() %></div>
						<%
									if(list[idx].getU_id().equals(user.getU_id())){
						%>
							<div class="feedBtns">
								<div class="feedModify" onclick="document.getElementById('feedModifyButton').click()">
									수정
									<input id="feedModifyButton" type="button" onclick="showModifier(<%=list[idx].getD_num() %>);" />
									
								</div>
								<div class="feedDelete" onclick="document.getElementById('feedDeleteButton').click()">
									삭제
									<input type="hidden" name="d_num" value="<%= list[idx].getD_num()%>"/>
									<input id="feedDeleteButton" type="button" onclick="doWhat(this.form, 'doDeleteTimeline.do')" />
								</div>
							</div>				
							</form>
						<%
									}
						%>
						</li>
						<%
								}
							}
							
						%>
					</ul>
					<p class="nomore">더 이상 표시할 두윗이 없습니다..! (;ㅅ;)</p>
				</div>		
			</div>
		</section>
	</div>
	<div id="modifierWrap">
		<div class="modifier">
			<div class="modifyWindow">
			<form name="modifyForm">
			<input type="hidden" name="d_num" />
			<div class="writeFeed">
				<textarea name="d_content" placeholder="아무말이나 적어보세요..!"></textarea>
				<div class="cancelModify" onclick="document.getElementById('cancelModifyButton').click()">
					취소
					<input type="button" id="cancelModifyButton" onclick="hideModifier(this.form)" />
				</div>
				<div class="modify" onclick="document.getElementById('modifyButton').click()">
					수정
					<input type="button" id="modifyButton" onclick="doWhat(this.form, 'doUpdateTimeline.do',true)" />
				</div>
			</div>
			</form>
		</div>
		</div>
	</div>
</body>
</html>