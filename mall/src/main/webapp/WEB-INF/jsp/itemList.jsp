<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 목록</h1>
	<table border="1">
		<tr>
			<th>번호</th> <th>상품명</th> <th>가격</th> <th>주문</th>
		</tr>
		<c:forEach var="item" items="${list}">
			<tr>
				<td>${itme.no}</td> <!-- item.getNo() -->
				<td>${itme.name}</td>
				<td>${itme.price}</td>
				<td><a href="${pageContext.request.contextPath}/Order">주문</a></td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<!-- 페이징 링크 ${pageContextPath.request.contextPath}/itemList.jsp?currentPage=0 -->
	</div>
</body>
</html>