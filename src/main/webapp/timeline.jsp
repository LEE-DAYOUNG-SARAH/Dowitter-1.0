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
				
				<!-- �α��� ���� -->
				<div class="loggedInNow">
					<a href="goMyFeed.do">@<%= user.getU_id() %></a>
					<a href="logout.do">�α׾ƿ�</a>
				</div>
				
				<!-- �α׾ƿ����� -->
				<!-- <div class="loggedOUtNow">
					<a href="goLogin.do">�α���</a>
					<a href="goJoin.do">ȸ������</a>
				</div> -->
			</div>
		</div>
	</section>
	<div id="wrap">
		<section id="timelineBody">
			<div class="timeline">
				<form>
				<div class="writeFeed">
					<textarea name="d_content" id="" cols="30" rows="10" placeholder="�ƹ����̳� �������..!"></textarea>
					<div class="write" onclick="document.getElementById('writeButton').click()">
						�۾���
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
									����
									<input id="feedModifyButton" type="button" onclick="showModifier(<%=list[idx].getD_num() %>);" />
									
								</div>
								<div class="feedDelete" onclick="document.getElementById('feedDeleteButton').click()">
									����
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
					<p class="nomore">�� �̻� ǥ���� ������ �����ϴ�..! (;��;)</p>
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
				<textarea name="d_content" placeholder="�ƹ����̳� �������..!"></textarea>
				<div class="cancelModify" onclick="document.getElementById('cancelModifyButton').click()">
					���
					<input type="button" id="cancelModifyButton" onclick="hideModifier(this.form)" />
				</div>
				<div class="modify" onclick="document.getElementById('modifyButton').click()">
					����
					<input type="button" id="modifyButton" onclick="doWhat(this.form, 'doUpdateTimeline.do',true)" />
				</div>
			</div>
			</form>
		</div>
		</div>
	</div>
</body>
</html>