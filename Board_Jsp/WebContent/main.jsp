<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.db.dao.BoardDao" %>
<%@ page import="com.db.dto.BoardDto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<% 
BoardDao dao = new BoardDao();
System.out.println("check");
List<BoardDto> list = dao.selectAll();

%>

<body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		
	});
	function allChk(){
		if($("input:checkbox[id='allcheck']").is(":checked")==true){
			console.log("checked");
			$("input:checkbox[id='chked']").prop("checked", "true");
		}else {
			console.log("unchecked");
			$("input:checkbox[id='chked']").prop("checked", "false");	/* <-- not working..  */		
		}
	}
</script>
	<%@ include file = "./fix/header.jsp"%>
	<h1>게시판 목록</h1>
	<form action="multidel.jsp" method="post" id="multidelete">
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
		
<%
	//for 반복문으로 테이블에 tr 태그 추가
	for(int i=0; i<list.size(); i++){
		int no = list.get(i).getBd_no();
%>
	<tr align="center">
		<td><input type="checkbox" name="chk" id="chked" value="<%=list.get(i).getBd_no()%>" /></td>
		<td><%=list.get(i).getBd_no() %></td>
		<td><%=list.get(i).getBd_name()%></td>
		<td><a href="selectone.jsp?bd_no=<%=no%>"><%=list.get(i).getBd_title()%><a/></td>
		<td><%=list.get(i).getBd_date() %></td>
		<td><a href="update.jsp?bd_no=<%=list.get(i).getBd_no()%>">수정</a></td>
		<td><a href="delete.jsp?bd_no=<%=list.get(i).getBd_no()%>">삭제</a></td>
	</tr>		
<%		
	}
%>
	
	<tr>
		<td colspan="7" align="right">
			<input type="submit" value="삭제" />
			<input type="button" value="글쓰기" onclick="location.href='insert.jsp'">
		</td>
	</tr>
			
	</table>
	</form>
	<%@ include file="./fix/footer.jsp" %>
</body>
</html>