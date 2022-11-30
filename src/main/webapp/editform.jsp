<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.dao.bean.User, com.dao.UserDao" %>

<%
String id = request.getParameter("id");
User u = UserDao.getRecordbyId(Integer.parseInt(id));
%>

<h1>Edit form</h1>

<form action="edituser.jsp" action="post">

	
	<input type="hidden" name="id" value="<%=u.getId()%>"/>
	<table>
	<tr>
	<td>First_name:</td>

	<td><input type="text" name="First_name" value="<%=u.getFirst_name()%>"></td>
	</tr>
	
	<tr>
	<td>Last_name</td>
	<td><input type="email" name="email" value="<%=u.getLast_name()%>"></td>	
	</tr>
		
	<tr>
	<td> Password</td>
	<td><input type="password" name="password" value="<%=u.getPassword()%>"></td>	
	</tr>
	
	
	
	<tr><td><input type="submit" value="Edit User"></td></tr>
	
	
	</table>





</form>




</body>
</html>