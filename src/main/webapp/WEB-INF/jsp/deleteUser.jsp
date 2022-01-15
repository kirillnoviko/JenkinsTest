<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete User</title>
</head>

<body>

<jsp:include page="menu.jsp"></jsp:include>

<h3>Delete User</h3>

<p style="color: red;">${errorString}</p>
<a href="userList">User List</a>

</body>
</html>