<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu MVC</title>
</head>
<body>
	<jsp:include page="./WEB-INF/views/common/header.jsp"/>
	<h3>메뉴 리스트 조회</h3>
	<button onclick="location.href = '${pageContext.servletContext.contextPath}/list'">
		메뉴 리스트 조회하기
	</button>
</body>
</html>