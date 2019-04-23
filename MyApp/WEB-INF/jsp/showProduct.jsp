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
<c:import url="header.jsp"/>
<table >
<tr>
<td valign="top">
<c:forEach items="${categoryList }" var="c">
	<a href="${pageContext.request.contextPath }/getProducts?catId=
	<c:out value="${c.getId() }"></c:out>">
	<c:out value="${c.getName() }"></c:out></a> <BR>
</c:forEach>
</td>
<td>
<c:forEach items="${productList }" var="p">
	<h3><c:out value="${p.getName() }"/><c:out value="${p.getShortDescription() }"/></h3>
	Price:<c:out value="${p.getPrice() }"/> <br>
	<BR><BR>
</c:forEach>
</td>
</tr>

</table>

</body>
</html>