<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); response.setContentType("text/html; charset=UTF-8");%>
<%@ page import="java.util.List, com.mvc.dto.MVCBoardDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		MVCBoardDto dto =(MVCBoardDto)request.getAttribute("dto");
%>
<h1>게시글 보기</h1>
	<table border="1">
		<col width="100"/>
		<col width="300"/>
		<tr>
			<th>NAME</th>
			<td><%= dto.getBd_name() %></td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td><%= dto.getBd_title() %></td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows="10" cols="60" readonly="true"><%= dto.getBd_content() %></textarea></td>
		</tr>
		<tr >
			<td colspan="2">
				<input type="button" value="수정" onclick="">
				<input type="button" value="삭제" onclick="">
				<input type="button" value="목록" onclick="location.href='contoller.jsp?command=main'">
			</td>
		</tr>
	</table>
</body>
</html>