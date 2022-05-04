<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="login" class="bean.loginBean" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="login"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
ID : <jsp:getProperty property="id" name="login"/>
PW : <jsp:getProperty property="pw" name="login"/>
</body>
</html>