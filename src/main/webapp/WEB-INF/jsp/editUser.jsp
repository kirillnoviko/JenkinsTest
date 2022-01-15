<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
</head>
<body>


<jsp:include page="menu.jsp"></jsp:include>

<h3>Edit User</h3>

<p style="color: red;">${errorString}</p>

<c:if test="${not empty user}">
    <form method="POST" action="${pageContext.request.contextPath}/editUser">
        <input type="hidden" name="id" value="${user.id}" />
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
                <td colspan = "2">
                    <input type="submit" value="Submit" />
                    <a href="${pageContext.request.contextPath}/userList">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</c:if>



</body>
</html>
