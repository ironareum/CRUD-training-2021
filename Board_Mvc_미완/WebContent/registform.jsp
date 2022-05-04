<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function idChkOk(){
		var chkid = document.getElementsByName("bm_id")[0].title;
		if(chkid=="n"){
			alert("아이디 중복체크를 해주세요.");
			document.getElementsByName("bm_id")[0].focus();
		}
	}
	function idChk(){
		var doc = document.getElementsByName("bm_id")[0];
		if(doc.value.trim()==""||doc.value==null){
			alert("아이디를 입력하세요");
		}else {
			var target = "logincontroller.jsp?command=idchk&bm_id="+doc.value.trim();
			window.open(target,"","width=500, height=500");
		}
	}
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="logincontroller.jsp">
	<input type="hidden" name="command" value="insertuser"/>
		<table border="1">
			<tr>
				<th>ID</th>
				<td><input type="text" name="bm_id" required="required" title="n"/></td>
				<td><input type="button" name="chk" value="중복체크" onclick="idChk()"/></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="text" name="bm_pw" required="required" onclick="idChkOk()"/></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="bm_name" required="required"/></td>
			</tr>
			<tr>
				<th>ADDR</th>
				<td><input type="text" name="bm_addr" required="required"/></td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td><input type="text" name="bm_email" placeholder="@Member.com" required="required"/></td>
			</tr>
			<tr>
				<th>PHONE</th>
				<td><input type="text" name="bm_phone" required="required"/></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="가입하기"/></td>
			</tr>
			
		</table>
	</form>
</body>
</html>