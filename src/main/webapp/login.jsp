<%--
  Created by IntelliJ IDEA.
  User: cse24-069
  Date: 10/09/2026
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>LIBIS Login</title>
</head>
<body>
<h2>LIBIS Member Login</h2>

<!-- Error message handling -->
<% String error = (String) request.getAttribute("error"); %>
<% if (error != null) { %>
<p style="color:red;"><%= error %></p>
<% } %>

<form action="LoginServlet" method="POST">
  <label for="email">Email:</label>
  <input type="text" id="email" name="email" required><br><br>

  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br><br>

  <button type="submit">Login</button>
</form>
</body>
</html>
