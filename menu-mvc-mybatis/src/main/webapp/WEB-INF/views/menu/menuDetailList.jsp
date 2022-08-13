<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Detail List</title>
</head>
<body>
	<h1>메뉴 목록 조회</h1>
	<table align="center" border="1">
		<tr>
			<th>메뉴 코드</th>
			<th>메뉴 명</th>
			<th>메뉴 가격</th>
			<th align=center>카테고리 코드</th>
			<th>카테고리 명</th>
			<th>참조 카테고리 코드</th>
			<th>주문 가능 여부</th>
		<tr>
		<c:forEach items="${ requestScope.menuDetailList }" var="menu">
			<tr>
				<td>${ menu.code }</td>
				<td>${ menu.name }</td>
				<td>${ menu.price }</td>
				<td align=center>${ menu.category.code }</td>
				<td>${ menu.category.name }</td>
				<td>${ menu.category.refCategorycode }</td>
				<td>${ menu.orderableStatus }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>