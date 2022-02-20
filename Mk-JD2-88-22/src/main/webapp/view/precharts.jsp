<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Charts Form</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/charts" method="post">
		<table border="1" style="width: 50%">

			<tr>
				<td>Enter your LOGIN</td>
				<td><input type="text"  name="login" /></td>
			</tr>
      <tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<input type="submit" value="Get my message" /></form>
</body>
</html>