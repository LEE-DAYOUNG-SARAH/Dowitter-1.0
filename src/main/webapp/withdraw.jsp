<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- head.jsp -->
<jsp:include page="head.jsp" />
<body>
	<jsp:include page="header.jsp" />
	<div id="wrap">
		<div class="contentBox contentBoxWithdraw">
			<form action="">
			<div id="content" class="contentWithdraw">
				<div class="title">ȸ��Ż��</div>
				<p class="contentBoxText">
					ȸ��Ż��� ȸ������ ��� ������ �����Ǹ�,<br>
					������ �� �����ϴ�.
				</p>
				<div class="btns">
					<div class="confirm" onclick="document.getElementById('confirmButton').click()">
						Ż��
						<input id="confirmButton" type="button" onclick="doWhat(this.form, 'doWithdraw.do')" />
					</div>
					<div class="cancel">
						<a href="">���</a>
					</div>
				</div>
			</div>
			</form>
		</div>
	</div>
</body>
</html>