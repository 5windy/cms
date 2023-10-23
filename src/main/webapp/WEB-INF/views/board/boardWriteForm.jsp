<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/form.css">
<title>Board</title>
</head>
<jsp:include page="/header"/>
<body>
	<c:if test="${empty log }">
		<c:redirect url="/login"/>
	</c:if>
	<section>
		<h2>글쓰기</h2>
		<form method="POST" action="/service" id="form">
			<input type="hidden" name="command" value="join">
			<div>
				<div class="group">
					<input type="text" name="author" id="author" value="${log.id }" readonly>
					<input type="text" name="title" id="title" placeholder="제목"> 
					<textarea rows="" cols="" name="content" placeholder="내용"></textarea>
				</div>
				<div class="error-msg">
					<ul>
						<li id="error-username">아이디는 필수 입력값입니다.</li>
						<li id="error-password">비밀번호는 필수 입력값입니다.</li>
					</ul>
				</div>
			</div>
			<input type="button" value="글작성" onclick="checkForm(form)" id="btn-submit">
		</form>
	</section>

	<script src="/resources/script/board-validation.js"></script>
</body>
<jsp:include page="/footer"/>
</html>