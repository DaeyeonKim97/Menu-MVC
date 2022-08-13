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
	<h3>메뉴 상세 리스트 조회</h3>
	<button onclick="location.href = '${pageContext.servletContext.contextPath}/detail-list'">
		메뉴 상세 리스트 조회하기
	</button>
	<h3>메뉴 상세 리스트 조회</h3>
	<button onclick="location.href = '${pageContext.servletContext.contextPath}/category-list'">
		카테고리 리스트 조회하기
	</button>
	<h3>메뉴 코드로 메뉴 조회</h3>
	<form action="menuCode">
		<label>메뉴 코드 :</label>
		<input type="number" name="menuCode" id="menuCode"/>
		<button type="submit">조회</button>
	</form>
	<h3>카테고리의 메뉴 조회</h3>
	<form action="categoryCode">
		<label>카테고리 코드 : </label>
		<input type="number" name="categoryCode" id="categoryCode"/>
		<button type="submit">조회</button>
	</form>
</body>
</html>