<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>

<h3>Product List</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${userList}" var="user" >
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>

            <td>
                <a href="editUser?id=${user.id}">Edit</a>
            </td>
            <td>
                <a href="deleteUser?id=${user.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="createUser" >Create User</a>


</body>
</html>