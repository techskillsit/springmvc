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
<h1>Welcome </h1>
<h3>Customer Details </h3>
<c:out value="${bank.getName() }"></c:out>
<BR>
List of Customers: <BR>
<c:forEach items="${bank.getcList() }" var="c">
<c:out value="${c.getName() }"/> <BR>
Plan: <c:out value="${c.getSubscription().getPlan() }"/><HR>
</c:forEach>
</body>
</html>