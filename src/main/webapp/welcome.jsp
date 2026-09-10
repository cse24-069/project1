<%--
  Created by IntelliJ IDEA.
  User: cse24-069
  Date: 10/09/2026
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>LIBIS Book Catalogue</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .actions a { margin-right: 10px; text-decoration: none; color: blue; }
    </style>
</head>
<body>

<!-- Greet the signed-in member by name -->
<h2>Welcome, ${sessionScope.loggedInMember.fullName}!</h2>
<p>Here is the current LIBIS catalogue:</p>

<!-- Render the collection as an HTML table -->
<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Genre</th>
        <th>Availability</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <!-- Iterate over the bookList request attribute -->
    <c:forEach var="book" items="${requestScope.bookList}">
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.genre}</td>

            <!-- EL handles the isAvailable() boolean automatically -->
            <td>${book.available ? 'Available' : 'Checked Out'}</td>

            <td class="actions">
                <!-- Dummy links as per requirements -->
                <a href="#">Search</a>
                <a href="#">Borrow</a>
                <a href="#">Reserve</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<a href="login.jsp">Logout</a>

</body>
</html>