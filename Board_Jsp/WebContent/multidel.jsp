<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8"); %>    
<%@ page import="com.db.dao.BoardDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] bd_nos = request.getParameterValues("chk");
	BoardDao dao=new BoardDao();
	int res =dao.multiDelete(bd_nos);
	
	if(res==bd_nos.length){
%>
	<script type="text/javascript">
		alert("체크된 글 모두 삭제 성공");
		location.href='main.jsp';
	</script>
<%		
	}else {
%>
	<script type="text/javascript">
		alert("체크된 글 모두 삭제 실패");
		location.href='main.jsp';
	</script>
<%		
	}
%>


</body>
</html>