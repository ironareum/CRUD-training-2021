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
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#updateForm").hide();
	});
	function updateFormView(){
		$("#updateForm").show();
		$("#borderForm").hide();
	}
	function back(){
		$(function(){
			$("#updateForm").hide();
		});
	}
</script>
<% 
	int new_no = Integer.parseInt(request.getParameter("bd_no"));
	BoardDao dao= new BoardDao();
	BoardDto dto = dao.selectOne(new_no);
%>
<div id="borderForm">
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
				<button type="button" onclick="updateFormView();">수정</button>&nbsp;&nbsp;
				<button type="button" onclick="location.href='delete.jsp?bd_no='<%=new_no%>'">삭제</button>&nbsp;&nbsp;
				<button type="button" onclick="location.href='main.jsp'">목록</button>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</div>



<div id="updateForm">
	<h1>글 수정</h1>
	<form action="update_alert.jsp" method="post">
	<input type="hidden" name="bd_no" value="<%=dto.getBd_no() %>" />
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
			<td><textarea rows="10" cols="60" name="bd_content" ><%= dto.getBd_content() %></textarea></td>
		</tr>
		<tr >
			<td colspan="2">
				<input type="submit" value="수정완료" />
				<button type="button" onclick="location.href='selectone.jsp?bd_no=<%=new_no%>'">취소</button>&nbsp;&nbsp;
			</td>
		</tr>
		</table>
	</form>
</div>
</body>
</html>