<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); response.setContentType("text/html; charset=UTF-8");%>
<%@ page import=" com.mvc.dto.BDMemberDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	BDMemberDto dto =(BDMemberDto) session.getAttribute("dto");
	if(dto == null){
		pageContext.forward("browser.html");
	}

%>
	<h1>메인화면</h1>
	<div>
		<span><%=dto.getBm_name()%>님, 환영합니다. [등급: <%=dto.getBm_role() %>]</span>
		<a href="logincontroller.jsp?command=logout">로그아웃</a>
	</div>
	<div>
		<div>
			<a href="">내 정보</a>
		</div>
	</div>
</body>
</html>