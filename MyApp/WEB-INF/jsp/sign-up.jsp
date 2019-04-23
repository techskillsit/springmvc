<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Sign-up</h1>


<sf:form method="post" action="${pageContext.request.contextPath }/sign-up-form" 
modelAttribute="user">
Name: <sf:input type="text" path="name"  /> <sf:errors path="name"></sf:errors><BR><BR>
Username: <sf:input type="text" path="username" /> <sf:errors path="username"></sf:errors><BR><BR>
Passowrd: <sf:input type="password" path="password" /> <sf:errors path="password"></sf:errors><BR><BR>

<input type="submit" value="Sign Up">

</sf:form>
</body>
</html>