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
        <h2>Welcome, <c:out value="${requestScope.member.fullName}"/>!</h2>
    </font>
</center>

<form action="${pageContext.request.contextPath}/catalogue" method="GET" align="center">
    <center>
        <font face="Arial" size="4">
            <label for="q">Search by title:</label>
            <input type="text" id="q" name="q" size="30" value="<c:out value='${requestScope.searchTerm}'/>">
            <input type="submit" value="Search">
            <c:if test="${not empty requestScope.searchTerm}">
                <a href="${pageContext.request.contextPath}/catalogue"><font color="#2980b9">Clear</font></a>
            </c:if>
        </font>
    </center>
</form>

<p align="center"><font face="Arial" size="4">
    <c:choose>
        <c:when test="${empty requestScope.searchTerm}">Here is the current LIBIS catalogue:</c:when>
        <c:otherwise>Results for "<c:out value="${requestScope.searchTerm}"/>":</c:otherwise>
    </c:choose>
</font></p>

<table border="1" cellpadding="10" cellspacing="0" width="90%" align="center" bordercolor="#bdc3c7">
    <thead>
    <tr bgcolor="#34495e">
        <th><font color="white" face="Arial">Title</font></th>
        <th><font color="white" face="Arial">Author</font></th>
        <th><font color="white" face="Arial">Genre</font></th>
        <th><font color="white" face="Arial">Availability</font></th>
        <th><font color="white" face="Arial">Actions</font></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${requestScope.bookList}" varStatus="status">
        <tr bgcolor="${status.index % 2 == 0 ? '#ffffff' : '#ecf0f1'}">
            <td><font face="Arial" color="#2c3e50"><c:out value="${book.title}"/></font></td>
            <td><font face="Arial" color="#7f8c8d"><c:out value="${book.author}"/></font></td>
            <td><font face="Arial" color="#7f8c8d"><c:out value="${book.genre}"/></font></td>
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
                <a href="#"><font color="#2980b9">Borrow</font></a> &nbsp;
                <a href="#"><font color="#2980b9">Reserve</font></a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${empty requestScope.bookList}">
        <tr><td colspan="5" align="center"><font face="Arial">No books match your search.</font></td></tr>
    </c:if>
    </tbody>
</table>

<br>
<center>
    <font face="Arial" size="4">
        <a href="${pageContext.request.contextPath}/logout"><font color="#c0392b">Logout</font></a>
    </font>
</center>

</body>
</html>