<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8"); %>     
<%@ page import="com.db.dao.BoardDao" %>
<%@ page import="com.db.dto.BoardDto" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <script type="text/javascript">
		if(alert("게시물을 삭제 하시겠습니까?")){
			
		};
	</script> -->

	<%  int bd_no = Integer.parseInt(request.getParameter("bd_no"));

		BoardDao dao= new BoardDao();
		int res =dao.delete(bd_no);
		
		if(res >0){
	%>
		<script typ="text/javascript">
		alert('게시물이 삭제 되었습니다.');
		location.href="main.jsp";
		</script>	
	<%
		}else {
	%>
		<script type="text/javascript">
		alert('게시물 삭제 실패.');
		location.href="main.jsp";
		</script>
	<%
		}
	%>
</body>
</html>