<%@page import="model.user.UserDao"%>
<%@page import="model.user.UserResponseDto"%>
<%@page import="model.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/style/form.css">
</head>
<jsp:include page="/header"/>
<body>
	<%
	if(session.getAttribute("log") == null)
		response.sendRedirect("/login");
	%>

	<section>
		<h2>회원탈퇴</h2>
		<form method="POST" action="/api/user/leave" id="form">
			<div>
				<div class="group">
					<input type="text" name="username" id="username" value="${log.username }" placeholder="${log.username }" readonly>
					<input type="password" name="password" id="password" placeholder="패스워드">
				</div>
				<div class="error-msg">
					<ul>
						<li id="error-username">아이디는 필수 입력값입니다.</li>
						<li id="error-password">비밀번호는 필수 입력값입니다.</li>
					</ul>
				</div>
			</div>
			<input type="button" value="회원탈퇴" id="btn-submit" onclick="checkForm(form)">
		</form>
	</section>
	<script src="/script/user-validation.js"></script>
</body>
<jsp:include page="/footer"/>
</html>