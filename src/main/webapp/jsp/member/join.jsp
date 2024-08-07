<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<a href="../home/main">메인 페이지로 </a>

	<h2>회원 정보 작성</h2>

	<form method="POST" action="doJoin">
		<div>
			아이디 : <input type="text" placeholder="아이디 입력" name="userId" />
		</div>
		<div>
			닉네임 : <input type="text" placeholder="비밀번호 입력" name="nickname">
		</div>
		<div>
			비밀번호 : <input type="password" placeholder="비밀번호 입력" name="password">
		</div>
		<button type="submit">가입</button>
	</form>



	<div>
		<a style="color: green" href="list">리스트로 돌아가기</a>
	</div>
</body>
</html>