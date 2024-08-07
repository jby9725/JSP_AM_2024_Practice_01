<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<a href="../home/main">메인 페이지로 </a>

	<h2>게시글 수정</h2>

	<form method="POST" action="doModify">
		<div>
			새 제목 : <input type="text" placeholder="수정 제목 입력" name="title" />
		</div>
		<div>
			새 내용 :
			<textarea type="text" placeholder="수정 내용 입력" name="body"></textarea>
		</div>
		<button type="submit">수정</button>
	</form>



	<div>
		<a style="color: green" href="list">리스트로 돌아가기</a>
	</div>
</body>
</html>