<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<title>Chart Form</title>
</head>
<body>
<h1>Your messages</h1>
<table border="1" >
<tr>
                    <th>Sender</th>
                    <th>Message</th>
                    <th>Time of message</th>
                   </tr>
<c:forEach var="item" items="${sessionScope.currentsList}">
                 <tr>
                    <th>${item.sender}</th>
                    <th>${item.message}</th>
                    <th>${item.time}</th>
                   </tr>
             </c:forEach>
</table>
</body>
</html>