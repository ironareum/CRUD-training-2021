<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); response.setContentType("text/html; charset=UTF-8");%>
<%@ page import="java.util.List, com.mvc.dto.BDMemberDto, com.mvc.dao.BDMemberDao"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String command = request.getParameter("command");
	BDMemberDao dao = new BDMemberDao();
	
	if(command.equals("login")){
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		BDMemberDto dto =dao.login(id, pw);
		
		if(dto.getBm_id()!=null){
			//설정한 시간동안만 값 공유하게 함
			/* 
			page: 해당 jsp에서만 공유 
			request: 요청부터 응담까지 공유
			session: 해당 브라우저 안에서 설정한 시간동안 공유(페이지 전환되어도 공유)
			application: 서비스 전체에서 공유 
			*/
			session.setAttribute("dto", dto);
			session.setMaxInactiveInterval(60*60); //단위:초 -> 총 60분 
			
			//로그인 성공시
			//관리자계정으로 로그인한 경우 -> 관리자 페이지로
			if(dto.getBm_role().equals("ADMIN")){
				response.sendRedirect("adminpage.jsp");
			}else {
				response.sendRedirect("userpage.jsp");
				/* 
				forward(): 요청과 응답의 제어권을 다른 페이지로 넘기더라도 주소가 변하지 않음. 요청정보와 응답정보가 유지.
				sendRedirect(): 브라우저에 표시되는 주소가 바뀌는 방식. 요청정보와 응답정보가 유지되지 않음.
				*/
			}
		} else { //로그인 실패시 
%>			
			<script type="text/javascript">
				alert("로그인 실패");
				location.href='controller.jsp?command=main';
			</script>
<%					
		}
	}
	else if(command.equals("logout")){
			//login 시 설정한 session 정보 삭제함
			session.invalidate();
			response.sendRedirect("login.jsp");
	}
	else if(command.equals("insertuser")){
		String bm_id =request.getParameter("bm_id");
		String bm_pw =request.getParameter("bm_pw");
		String bm_name =request.getParameter("bm_name");
		String bm_addr =request.getParameter("bm_addr");
		String bm_email =request.getParameter("bm_email");
		String bm_phone =request.getParameter("bm_phone");
		
		BDMemberDto dto = new BDMemberDto();
		dto.setBm_id(bm_id);
		dto.setBm_pw(bm_pw);
		dto.setBm_name(bm_name);
		dto.setBm_addr(bm_addr);
		dto.setBm_email(bm_email);
		dto.setBm_phone(bm_phone);
		
		int res = dao.inserUser(dto);
		
		if(res>0){
%>
		<script type="text/javascript">
			alert("회원가입 성공");
			location.href="login.jsp";
		</script>			
<%		}else {
%>
		<script type="text/javascript">
			alert("회원가입 실패");
			location.href="registform.jsp";
		</script>			
<%		}
	}
	else if(command.equals("idchk")){
		String bm_id = request.getParameter("bm_id");
		String res = dao.idChk(bm_id);
		
		boolean idNotUsed =true;
		
		if(res != null){
			idNotUsed =false;
		}
		response.sendRedirect("idchk.jsp?idnotused="+idNotUsed);
	}
%>
</body>
</html>