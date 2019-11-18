<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>My Login</h1>

<HR>
<c:if test='${param.status == "invalid" }'>
<font color="red">Invalid Credentials!!</font>
</c:if>

<c:if test='${action == "logout" }'>
<font color="red">You are logged out!!</font>
</c:if>

<c:out value="${msg }"/>
<form method="post" action="${pageContext.request.contextPath }/login">
Username: <input type="text" name="username" value="<c:out value="${user.getUsername() }"/>"> <BR><BR>
Password: <input type="password" name="password"> <BR><BR>
<input type="submit" value="Login">
</form>
<hr>
<a href="${pageContext.request.contextPath }/sign-up">Sign-Up</a>
</body>
</html>