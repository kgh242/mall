<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ȸ������</h1>
	<form action="<%=request.getContextPath() %>/AddMember" method="post">
	<table border = 1 >
		<tr>
			<td>���̵�</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>��й�ȣ</td>
			<td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="ȸ������"/></td>
		</tr>
	</table>		
	</form>
</body>
</html>