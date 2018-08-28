<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html title="Users list">
<h2>Users List</h2>
<form action="/derby-proj/users/delete" method="post">
    <table border="1" style="border-collapse: collapse;">
        <tr>
            <th></th>
            <th style="padding: 10px;">Name</th>
            <th style="padding: 10px;">Email</th>
            <th style="padding: 10px;">Role</th>
            <th style="padding: 10px;">Del</th>
        </tr>
        <c:forEach var="user" items="${requestScope.users}">
            <tr>
                <td><input name="id" type="hidden" value="${user.id}"></td>
                <td style="padding: 10px;">${user.name}</td>
                <td style="padding: 10px;">${user.email}</td>
                <td style="padding: 10px;">${user.role}</td>
                <td style="padding: 10px;"><input type="submit" value="X"></input></td>
            </tr>
        </c:forEach>
    </table>
</form>
<h2>Add User</h2>
<form action="/derby-proj/users/list" method="post">
    <table>
        <tr>
            <td align="right">Id:
            <td><input name="id" placeholder="Id" type="text"><br>
        <tr>
            <td align="right">Name:
            <td><input name="name" placeholder="Name" type="text"><br>
        <tr>
            <td align="right">Email:
            <td><input name="email" placeholder="example@mail.com" type="text"><br>
        <tr>
            <td align="right">Password:
            <td><input name="password" placeholder="Password" type="password"><br>
        <tr>
            <td align="right">Role:
            <td><input name="role" placeholder="Role" type="text"><br>
    </table>
    <input type="submit" value="Add"></input>
</form>
</html>
