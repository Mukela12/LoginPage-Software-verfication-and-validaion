<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@page import="java.util.*,com.dao.UserDao,com.dao.bean.User" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>List of Users</h1>

<%
	List<User>list = UserDao.getAllRecord();
	request.setAttribute("list",list);
%>


<table border="1" width="100%">

<tr>
	<th>ID</th>
	<th>FirstName</th>
	<th>LastName</th>
    <th>UserName</th>
	<th>Password</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>

<c:forEach items="${list}" var="u">

<tr>
	<td>${ u.getId()}</td>
	<td>${u.getFirst_name()}</td>
	<td>${u.getLast_name()}</td>
	<td>${u.getUsername()}</td>
	<td>${ u.getPassword()}</td>
	
	<td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>
	<td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td>

</tr>

</c:forEach>
</table>

</body>
</html>