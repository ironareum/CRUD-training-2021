<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
<form action="logincontroller.jsp" method="post">
<input type="hidden" name="command" value="login"/>
	<table border="1">
		<tr>
			<th>ID</th>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" name="pw"/></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" name="login" value="login" />
				<input type="button" name="regist" value="regist" onclick="location.href='registform.jsp'"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>