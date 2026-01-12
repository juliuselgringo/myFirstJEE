<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <link rel="stylesheet" href="assets/css/indexStyle.css">
</head>
<body>
  <jsp:include page="/assets/templateJsp/header.jsp" />

  <h1><%= "Hello World!" %></h1>
  <form method="post" action="<c:url value="/hello-servlet" />">
    <input type="text" name="firstName" placeholder="prénom" >
    <input type="text" name="lastName" placeholder="nom" >
    <input type="number" name="age" placeholder="age">
    <button type="submit">Valider</button>
  </form>
  <br/>
  <div id="displayUser">
    <c:forEach var="user" items="${requestScope.usersToDisplay}">
      <ul>
        <li>${user.firstName}</li>
        <li>${user.lastName}</li>
        <li>${user.age}</li>
      </ul>
    </c:forEach>
  </div>

  <a href="<c:url value="/hello-servlet?lastName=Rousselot&firstName=Julien&age=45" />">Hello Servlet</a>

  <jsp:include page="/assets/templateJsp/footer.jsp" />
  <script src="assets/scriptFront/indexScript.js"></script>
</body>
</html>