<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html title="Users list">
    <h2>Users List</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Role</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td class="content">${user.name}</td>
                <td class="content">${user.email}</td>
                <td class="content">${user.role}</td>
            </tr>
        </c:forEach>
    </table>
</html>
