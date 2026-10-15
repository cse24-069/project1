<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>LIBIS Login</title>
</head>
<body bgcolor="#e6f2ff" text="#003366">

<center>
  <br><br>
  <font face="Verdana" size="6" color="#004080">
    <h2>LIBIS Member Login</h2>
  </font>

  <c:if test="${not empty requestScope.error}">
    <font color="red" size="4"><b><c:out value="${requestScope.error}"/></b></font>
  </c:if>

  <br><br>

  <table border="2" cellpadding="15" cellspacing="0" bgcolor="#ffffff" bordercolor="#004080">
    <tr>
      <td>
        <form action="${pageContext.request.contextPath}/login" method="POST">
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