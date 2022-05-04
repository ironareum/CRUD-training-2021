<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>  
<%@ page import="com.db.dao.BoardDao" %>
<%@ page import="com.db.dto.BoardDto" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "./fix/header.jsp"%>
<% int bd_no = Integer.parseInt(request.getParameter("bd_no"));
BoardDao dao= new BoardDao();
BoardDto dto = dao.selectOne(bd_no);

%>
	<h1>수정하기</h1>
	<form action="update_alert.jsp" method="post">
		<input type="hidden" name="bd_no" value="<%=dto.getBd_no()%>" />
		<table border="1">
		<col width="100"/>
		<col width="300"/>
		<tr>
			<th>NAME</th>
			<td><%= dto.getBd_name() %></td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td><input type="text" name="bd_title" value="<%= dto.getBd_title() %>"/></td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows="10" cols="60" name="bd_content"><%= dto.getBd_content() %></textarea></td>
		</tr>
		<tr >
			<td colspan="2">
				<input type="submit" value="수정">
			</td>
		</tr>
	</table>
	</form>
	<%@ include file="./fix/footer.jsp" %>
</body>
</html>