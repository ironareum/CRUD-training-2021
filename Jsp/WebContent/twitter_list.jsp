<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); response.setContentType("text/html; charset=utf-8"); %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="jquery/jquery.min.js"></script>
<script src="jquery/jquery-migrate.min.js"></script>
<script>
	$(function(){
		$("#back").on("click",function(){
			console.log("go back")
			location.href="twitter_login.jsp";
		})
	});
</script>
</head>
<body>
<% 
	String session_id =(String)session.getAttribute("session_id");
	if(session_id==null){
		session_id = "Guest";
	}
	
	ArrayList<String> msgs=(ArrayList<String>)application.getAttribute("msgs");
	if(msgs!=null){
		for(String msg : msgs){
			out.println("<li>"+msg+"</li>");
		}
	}
	
%>
	<input type="button" id="back" value="뒤로가기"/>
	<p id="id"> ${id} <%= session_id %>님, </p>
	<form action="twitt.jsp" method="post">
		<input type="text" name="msg" />
		<input type="submit" value="Tweet"/>
	</form>
	<hr />
	<div id="chat">
	
	</div>
</body>
</html>