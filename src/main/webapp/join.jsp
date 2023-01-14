<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- head.jsp -->
<jsp:include page="head.jsp" />
<body>
	<jsp:include page="header.jsp" />
	<div id="wrap">
		<div class="contentBox contentBoxJoin">
			<form name="joinForm">
			<div id="content" class="contentJoin">
				<div class="title">회원가입</div>
				<div class="row">
					<div class="inputBox">
						<label for="idInput">ID</label>
						<input type="text" id="idInput" name="u_id" title="ID" />
					</div>
				</div>
				<div class="row">
					<div class="inputBox">
						<label for="pwInput">PW</label>
						<input type="password" id="pwInput" name="u_pw" title="PASSWORD" />
					</div>
				</div>
				<div class="row">
					<div class="inputBox">
						<label for="reInput">RE</label>
						<input type="password" id="reInput" name="u_re" title="RETRY" />
					</div>
				</div>
				<div class="btns">
					<div class="confirm" onclick="document.getElementById('confirmButton').click()">
						회원가입
						<input id="confirmButton" type="button" onclick="doWhat(this.form, 'doJoin.do', true, true)" />
					</div>
					<div class="cancel">
						<a href="cancelJoin.do">취소</a>
					</div>
				</div>
			</div>
			</form>
		</div>
	</div>
</body>
</html>