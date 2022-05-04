<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	onload = function(){
		var id = opener.document.getElementsByName("bm_id")[0].value;
		document.getElementsByName("id")[0].value=id;
	} 
	
	function idok(bool) {
		opener.console.log(bool);
		if(bool==true){ /* <--- "true"로 하면 not working. 왜??  */
			opener.console.log("사용가능");
			opener.document.getElementsByName("bm_pw")[0].focus();
			opener.document.getElementsByName("bm_id")[0].title="y";
			opener.document.getElementsByName("chk")[0].value="사용가능";
		}else {
			opener.document.getElementsByName("bm_id")[0].focus();
		}
		self.close();
	}
</script>
</head>
<body>
<% String idnotused = request.getParameter("idnotused"); 
%>

	<table border="1">
		<tr>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<td><%= idnotused.equals("true")?"아이디 생성가능":"아이디 중복" %></td>
		</tr>
		<tr>
			<td><input type="button" value="확인" onclick="idok(<%=idnotused%>)" /></td>
		</tr>
	</table>
</body>
</html>