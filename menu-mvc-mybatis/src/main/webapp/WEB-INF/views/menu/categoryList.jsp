<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category List</title>
</head>
<body>
	<h1>카테고리 목록 조회</h1>
	<hr>
	<table align="center" border="1">
		<tr>
			<th>카테고리 코드</th>
			<th>카테고리 명</th>
			<th>참조 카테고리 코드 </th>
		<tr>
		<c:forEach items="${requestScope.categoryList}" var="category">
		<tr>
			<td>${ category.code }</td>
			<td>${ category.name }</td>
			<td>${ category.refCategorycode }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>