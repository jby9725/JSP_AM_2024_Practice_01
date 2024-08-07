<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>

	<form method="POST" action="doLogin">
		<div>
			아이디 : <input type="text" placeholder="아이디 입력" name="userId" />
		</div>
		<div>
			비밀번호 : <input type="password" placeholder="비밀번호 입력" name="password" />
		</div>
		<button type="submit">로그인</button>
	</form>



	<div>
		<a href="../home/main">메인 페이지로 </a>
	</div>

</body>
</html>