<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>LIBIS Login</title>
</head>
<body bgcolor="#e6f2ff" text="#003366"> <!-- Light blue background, dark blue text -->

<center> <!-- Centers everything horizontally -->
  <br><br>
  <font face="Verdana" size="6" color="#004080">
    <h2>LIBIS Member Login</h2>
  </font>

  <!-- Error message handling -->
  <% String error = (String) request.getAttribute("error"); %>
  <% if (error != null) { %>
  <font color="red" size="4"><b><%= error %></b></font>
  <% } %>

  <br><br>

  <!-- Using a table to create a "box" around the form -->
  <table border="2" cellpadding="15" cellspacing="0" bgcolor="#ffffff" bordercolor="#004080">
    <tr>
      <td>
        <form action="LoginServlet" method="POST">
          <font face="Arial" size="4" color="#333333">
            <label for="email">Email:</label>
          </font><br>
          <input type="text" id="email" name="email" required size="30"><br><br>

          <font face="Arial" size="4" color="#333333">
            <label for="password">Password:</label>
          </font><br>
          <input type="password" id="password" name="password" required size="30"><br><br>

          <center>
            <input type="submit" value="Login">
          </center>
        </form>
      </td>
    </tr>
  </table>
</center>

</body>
</html>