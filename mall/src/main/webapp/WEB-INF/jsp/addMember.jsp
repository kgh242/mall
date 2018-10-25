<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="<%=request.getContextPath() %>/AddMember" method="post">
	<table border = 1 >
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="회원가입"/></td>
		</tr>
	</table>		
	</form>
</body>
</html>