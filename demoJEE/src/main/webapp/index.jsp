<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <link rel="stylesheet" href="indexStyle.css">
</head>
<body>
  <h1><%= "Hello World!" %></h1>
  <form method="post" action="hello-servlet">
    <input type="text" name="first-name" placeholder="prénom">
    <input type="text" name="last-name" placeholder="nom">
    <input type="number" name="age" placeholder="age">
    <button type="submit">Valider</button>
  </form>

<br/>

<a href="hello-servlet?last-name=Rousselot&first-name=Julien&age=45">Hello Servlet</a>
</body>
</html>