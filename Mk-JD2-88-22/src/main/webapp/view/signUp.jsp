<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration form</title>
</head>
<body>
<h1>Registration form</h1>

<form action="${pageContext.request.contextPath}/signUp" method="post">
 <c:if test="${req.getAttribute("userExists")==true}">
        <h2, style=color:red;>This LOGIN is Exists</h2>

    </c:if>
			<table border="1" style="with: 100%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="first_name" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="last_name" /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="login" /></td>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr></table>

				<input type="submit" value="Submit" /></form>

</body>
</html>