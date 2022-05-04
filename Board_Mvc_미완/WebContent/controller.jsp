<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); response.setContentType("text/html; charset=UTF-8");%>
<%@ page import="java.util.List, com.mvc.dto.MVCBoardDto, com.mvc.dao.MVCBoardDao, com.mvc.dto.BDMemberDto, com.mvc.dao.BDMemberDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//요청이 담긴 매개변수 가져오기
	String command = request.getParameter("command");
	MVCBoardDao dao = new MVCBoardDao();
	
	//요청이 main 일시,
	if(command.equals("main")){
		List<MVCBoardDto> list = dao.selectAll();
		request.setAttribute("boardlist", list);
		pageContext.forward("main.jsp");
	}
	else if(command.equals("selectone")){
		int bd_no= Integer.parseInt(request.getParameter("bd_no"));
		MVCBoardDto dto = dao.selectOne(bd_no);
		request.setAttribute("dto", dto);
		pageContext.forward("selectone.jsp");
	}
	else if(command.equals("bd_insert")){
		pageContext.forward("bd_insert.jsp");
	}
	else if(command.equals("insert")){
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		MVCBoardDto dto =new MVCBoardDto();
		dto.setBd_name(name);
		dto.setBd_title(title);
		dto.setBd_content(content);
		int res =dao.insert(dto);
		if(res >0){
			%>
				<script type="text/javascript">
				alert('게시물이 등록되었습니다.');
				location.href="controller.jsp?command=main";
				</script>	
			<%
				}else {
			%>
				<script type="text/javascript">
				alert('게시물이 등록 실패.');
				location.href="controller.jsp?command=insert";
				</script>
			<%
				}
			%>
<%
	}
%>
</body>
</html>