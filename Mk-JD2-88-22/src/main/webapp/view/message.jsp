<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8");%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chart Form</title>
</head>
<body>
<h1>You are authorized. Chat is available.</h1>
<form action="${pageContext.request.contextPath}/message" method="post">
		<table border="1" style="with: 500%">
      <tr>
				<td>Recipient</td>
				<td><input type="text"  name="recipient" /></td>
			</tr>
			<tr>
				<td>Message</td>
				<td><textarea input type="text"style="width: 500px; height: 50px;" name="message"></textarea></td>
			</tr>

		</table>
		<input type="submit" value="Send" />
		</form>
<form action="${pageContext.request.contextPath}/view/precharts.jsp" method="post">

    <input  type="submit"value="Go to Chats" />
     </form>
</body>
</html>