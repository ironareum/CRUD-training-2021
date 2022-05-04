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
<h1>글쓰기</h1>
	<form action="controller.jsp" method="post">
		<input type="hidden" name="command" value="insert"/>
		<table border="1">
			<col width="100"/>
			<col width="300"/>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="title"/></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows="10" cols="60" name="content"></textarea></td>
			</tr>
			<tr >
				<td colspan="2" align="right">
					<input type="submit" value="저장">
					<input type="button" value="취소" onclick="location.href='controller.jsp?command=main'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>