<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success!</title>
</head>
<body>
	<script type="text/javascript">
		const successCode = '${requestScope.successCode}';
		alert("success: "+successCode);
		location.href = '${pageContext.servletContext.contextPath}';
	</script>
</body>
</html>