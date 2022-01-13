<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create User</title>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>

<h3>Create Product</h3>

<p style="color: red;">${errorString}</p>

<form method="POST" action="${pageContext.request.contextPath}/createUser">
    <table border="0">

        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${user.name}" /></td>
        </tr>
        <tr>
            <td>SurName</td>
            <td><input type="text" name="surname" value="${user.surname}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit" />
                <a href="userList">Cancel</a>
            </td>
        </tr>
    </table>
</form>



</body>
</html>