<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Home </h1> 
<sec:authentication property="principal" var="user"/>
<sec:authorize access="isAuthenticated()">
<div align="right">
Welcome <c:out value="${user.username }"/>
<BR><a href="${pageContext.request.contextPath }/logout">Logout</a></div>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
	<div align="right"><a href="${pageContext.request.contextPath }/sign-up">Sign-Up</a></div>
</sec:authorize>


<a href="${pageContext.request.contextPath }/show-report">Show Report</a> <BR><BR>
<a href="${pageContext.request.contextPath }/show-users">Show Users</a> <BR><BR>
<hr>
<a href="${pageContext.request.contextPath }/sign-up">Sign-up</a> <BR><BR>

 <c:out value="${user.getUsername() }"/> <BR>
 <c:out value="${user.getPassword() }"/>
</body>
</html>