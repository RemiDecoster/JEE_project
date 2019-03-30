<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@page import="java.util.Date" %>
<% 
String myParameter=request.getParameter("param");
Date now = new Date();
%>
<head>
<meta charset="UTF-8">
<title>Bonjour la Bretagne</title>
</head>
<body>
	<h1>Bonjour la Bretagne</h1>
	<p> val p : <%=myParameter %> <p>
	<p> date req : <%=now.toString() %> <p>	
</body>
</html>