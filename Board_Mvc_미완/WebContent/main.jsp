<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<% request.setCharacterEncoding("UTF-8"); response.setContentType("text/html; charset=UTF-8");%>
<%@ page import="java.util.List,com.mvc.dto.MVCBoardDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<% List<MVCBoardDto> list = (List<MVCBoardDto>)request.getAttribute("boardlist"); %>

	<h4 style="text-align:right; margin-right:30px;"><a href="login.jsp">로그인</a></h4>
	<h1>게시판 목록</h1>
	<form action="" >
	<table border="1">
		<col width="50px"/>
		<col width="100px"/>
		<col width="200px"/>
		<col width="100px"/>
		<col width="100px"/>
		<col width="100px"/>
		<tr >
			<th><input type="checkbox" name="all" id="allcheck" onclick="allChk(this.check);"/></th>
			<th>No</th>
			<th>Name</th>
			<th>Title</th>
			<th>Date</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		
<%-- <%
	//for 반복문으로 테이블에 tr 태그 추가
	for(MVCBoardDto dto:list){
%> --%>
<c:forEach var="dto" items="${boardlist}">
	<tr align="center">
<%-- 		<td><%=dto.getBd_no() %></td>
		<td><%=dto.getBd_name()%></td>
		<td><a href="controller.jsp?command=selectone&bd_no=<%=dto.getBd_no() %>"><%=dto.getBd_title()%><a/></td>
		<td><%=dto.getBd_date()%></td>  --%>
		<td>${dto.bd_no}</td>
		<td>${dto.bd_name}</td>
		<td><a href="controller.jsp?command=selectone&bd_no=${dto.bd_no}">${dto.bd_title}<a/></td>
		<td>${dto.bd_date}</td> 
		<td><a href="">수정</a></td>
		<td><a href="">삭제</a></td>
	</tr>	
</c:forEach>
<%-- <% } %> --%>
	<tr>
		<td colspan="6">
			<input type="submit" value="삭제"/>
			<input type="button" value="글쓰기" onclick="location.href='controller.jsp?command=bd_insert'"/>
		</td>
	</tr>
	</table>
	</form>
</body>
</html>