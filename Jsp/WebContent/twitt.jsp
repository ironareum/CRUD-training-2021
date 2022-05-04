<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<% request.setCharacterEncoding("UTF-8"); response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String msg = request.getParameter("msg");
	String session_id=(String) session.getAttribute("session_id");
	
	ArrayList<String> msgs=(ArrayList<String>)application.getAttribute("msgs");
	
	
	if(msgs == null){
		msgs=new ArrayList<String>();
		application.setAttribute("msgs", msgs);
	}
	msgs.add(session_id+ "::"+ msg+" "+ new java.util.Date());
	
	response.sendRedirect("twitter_list.jsp");
	%>
	
</body>
</html>