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

	<script type="text/javascript">
		function JoinForm__submit(form) {
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
			if (form.passwordConfirm.value.trim().length == 0) {
				alert('비밀번호 확인을 입력하시오.');
				return;
			}
			
			if(form.password.value.trim() != form.passwordConfirm.value.trim()){
				alert('비밀번호가 일치하지 않습니다.');
				form.password.focus();
				return;
			}
			
			if (form.nickname.value.trim().length == 0) {
				alert('닉네임을 입력하시오.');
				return;
			}
			
// 			전부 다 입력되어있다.
//			비밀번호도 똑같다.
			form.submit();
		}
	</script>
	<!-- onsubmit 사용 -->
	<!-- if(confirm('진짜 이동?') == false) return false; -->
	<form method="POST" action="doJoin"
		onsubmit="JoinForm__submit(this); return false;">
		<div>
			아이디 : <input autocomplete="off" type="text" placeholder="아이디 입력"
				name="userId" />
		</div>
		<div>
			닉네임 : <input autocomplete="off" type="text" placeholder="비밀번호 입력"
				name="nickname" />
		</div>
		<div>
			비밀번호 : <input autocomplete="off" type="password"
				placeholder="비밀번호 입력" name="password" />
		</div>
		<div>
			비밀번호 확인 : <input autocomplete="off" type="password"
				placeholder="비밀번호 재입력" name="passwordConfirm" />
		</div>
		<button type="submit">가입</button>
	</form>

	<div>
		<a style="color: green" href="../article/list">리스트로 돌아가기</a>
	</div>
	
</body>
</html>