<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
<a href="../home/main">메인 페이지로 </a>

	<h2>게시글 작성</h2>

	<form method="POST" action="doWrite">
		<div>
			제목 : <input type="text" placeholder="제목 입력" name="title" />
		</div>
		<div>
			내용 :
			<textarea type="text" placeholder="내용 입력" name="body"></textarea>
		</div>
		<button type="submit">작성</button>
	</form>



	<div>
		<a style="color: green" href="list">리스트로 돌아가기</a>
	</div>
</body>
</html>