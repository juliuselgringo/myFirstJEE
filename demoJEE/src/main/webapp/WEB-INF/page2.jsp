<%--
  Created by IntelliJ IDEA.
  User: DEV01
  Date: 23/12/2025
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page 2</title>
</head>
<body>
    <jsp:include page="/assets/templateJsp/header.jsp" />

    <h1>${message}</h1>
    <h2>M. ${newUser.firstName} ${newUser.lastName} vous avez ${newUser.age}</h2>

    <jsp:include page="/assets/templateJsp/footer.jsp" />
</body>
</html>
