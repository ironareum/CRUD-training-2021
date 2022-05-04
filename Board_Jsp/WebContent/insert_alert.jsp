<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

	<%
		String name = request.getParameter("bd_name");
		String title = request.getParameter("bd_title");
		String content = request.getParameter("bd_content");
		
		//System.out.printf("name: %s, title: %s, content: %s%n", name, title, content);
		
		BoardDto dto= new BoardDto();
		dto.setBd_name(name);
		dto.setBd_title(title);
		dto.setBd_content(content);
		
		BoardDao dao= new BoardDao();
		int res =dao.insert(dto);
		
		if(res >0){
	%>
		<script typ="text/javascript">
		alert('게시물이 등록되었습니다.');
		location.href="main.jsp";
		</script>	
	<%
		}else {
	%>
		<script type="text/javascript">
		alert('게시물이 등록 실패.');
		location.href="insert.jsp";
		</script>
	<%
		}
	%>
	
</body>
</html>