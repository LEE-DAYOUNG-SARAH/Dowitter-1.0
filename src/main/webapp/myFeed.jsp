<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.green.dto.Doc" %>
<%@ include file="jspf/checkLogin.jspf" %>
<!-- head.jsp -->
<jsp:include page="head.jsp" />
<%
	Doc[] list = (Doc[])request.getAttribute("list");
%>
<body>
	<!-- ��� include -->
	<jsp:include page="header.jsp" />
	<div id="wrap">
		<section id="myFeedBody">
			<div class="myProfile">
				<p class="myProfileId">@<%= user.getU_id() %></p>
				<form>
					<div class="myProfileModify" onclick="document.getElementById('modifyButton').click()">
					ȸ����������
					<input id="modifyButton" type="button" name="modify" onclick="doWhat(this.form, 'goModify.do')" />
				</div>
				</form>
			</div>
			<div class="myTimeline">
				<form>
				<div class="writeFeed">
					<textarea name="d_content" id="" cols="30" rows="10" placeholder="�ƹ����̳� �������..!"></textarea>
					<div class="write" onclick="document.getElementById('writeButton').click()">
						�۾���
						<input type="button" id="writeButton" onclick="doWhat(this.form, 'doWriteMyFeed.do', true)" />
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
							<form>
								<div class="feedTitle">
								<a class="feedId" href="">@<%= list[idx].getU_id() %></a>
								<span class="feedDate"><%= list[idx].getD_date() %></span>
							</div>
							
							<div class="feedContent"><%= list[idx].getD_content() %></div>
							<div class="feedBtns">
								<div class="feedModify" onclick="showModifier()">
									����
								</div>
								<div class="feedDelete" onclick="document.getElementById('feedDeleteButton').click()">
									����
									<input type="hidden" name="d_num" value="<%=list[idx].getD_num()%>"/>
									<input id="feedDeleteButton" type="button" onclick="doWhat(this.form, 'doDeleteMyFeed.do')" />
								</div>
							</div>
							</form>
							<%
								}
							}
							%>
						</li>
					</ul>
					<p class="nomore">�� �̻� ǥ���� ������ �����ϴ�..! (;��;)</p>
				</div>		
			</div>
		</section>
	</div>
	<div id="modifierWrap">
		<div class="modifier">
			<div class="modifyWindow">
			<form>
			<div class="writeFeed">
				<textarea name="d_content" placeholder="�ƹ����̳� �������..!"></textarea>
				<div class="cancelModify" onclick="hideModifier()">
					���
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