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

<script type="text/javascript">
		function LoginForm__submit(form) {
			// console.log('form.userId.value : ' + form.userId.value);
			// trim() : 쓸모없는 공백 제거
			if (form.userId.value.trim().length == 0) {
				alert('아이디를 입력하시오.');
				return;
			}
			if (form.password.value.trim().length == 0) {
				alert('비밀번호를 입력하시오.');
				return;
			}
			
// 			전부 다 입력되어있다.
			form.submit();
		}
	</script>

	<form method="POST" action="doLogin"
	onsubmit="LoginForm__submit(this); return false;">
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