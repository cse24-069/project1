<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>LIBIS Book Catalogue</title>
</head>
<body bgcolor="#f4f4f4" text="#222222">

<center>
    <font face="Georgia" size="7" color="#2c3e50">
        <h2>Welcome, ${sessionScope.loggedInMember.fullName}!</h2>
    </font>
</center>

<p align="center"><font face="Arial" size="4">Here is the current LIBIS catalogue:</font></p>

<!-- Table with borders and colors -->
<table border="1" cellpadding="10" cellspacing="0" width="90%" align="center" bordercolor="#bdc3c7">
    <thead>
    <tr bgcolor="#34495e"> <!-- Dark blue-gray header -->
        <th><font color="white" face="Arial">Title</font></th>
        <th><font color="white" face="Arial">Author</font></th>
        <th><font color="white" face="Arial">Genre</font></th>
        <th><font color="white" face="Arial">Availability</font></th>
        <th><font color="white" face="Arial">Actions</font></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${requestScope.bookList}" varStatus="status">
        <!-- Alternating row colors using varStatus -->
        <tr bgcolor="${status.index % 2 == 0 ? '#ffffff' : '#ecf0f1'}">
            <td><font face="Arial" color="#2c3e50">${book.title}</font></td>
            <td><font face="Arial" color="#7f8c8d">${book.author}</font></td>
            <td><font face="Arial" color="#7f8c8d">${book.genre}</font></td>

            <td>
                <c:choose>
                    <c:when test="${book.available}">
                        <font color="green" face="Arial"><b>Available</b></font>
                    </c:when>
                    <c:otherwise>
                        <font color="red" face="Arial"><b>Checked Out</b></font>
                    </c:otherwise>
                </c:choose>
            </td>

            <td>
                <!-- Dummy links -->
                <a href="#"><font color="#2980b9">Search</font></a> &nbsp;
                <a href="#"><font color="#2980b9">Borrow</font></a> &nbsp;
                <a href="#"><font color="#2980b9">Reserve</font></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<center>
    <font face="Arial" size="4">
        <a href="login.jsp"><font color="#c0392b">Logout</font></a>
    </font>
</center>

</body>
</html>