<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@page import="com.dao.UserDao" %>
<jsp:useBean id="u" class="com.dao.bean.User"></jsp:useBean>>
<jsp:setProperty property="*" name="u"/>
<%

int i = UserDao.save(u);

if(i>0){
	
	response.sendRedirect("userLogin.html");
	
}else{

	response.sendRedirect("adduser_error.jsp");
	
}

%>






</body>
</html>