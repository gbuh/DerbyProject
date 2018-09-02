<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html title="Users list">
<h2>Edit User</h2>
<form action="/derby-proj/users/edit" method="post">
<c:url var="user" value="entity.UserM"/> 
    <table border="1" style="border-collapse: collapse;">
        <tr>
            <th></th>
            <th style="padding: 10px;">Name</th>
            <th style="padding: 10px;">Email</th>
            <th style="padding: 10px;">Password</th>
            <th style="padding: 10px;">Role</th>
        </tr>
            <tr>
                <td><input name="id" type="hidden" value="${user.id}"></td>
                <td style="padding: 10px;">${user.name}</td>
                <td style="padding: 10px;">${user.email}</td>
                <td style="padding: 10px;">${user.password}</td>
                <td style="padding: 10px;">${user.role}</td>
            </tr>
    </table>
</form>
    <input type="submit" value="Save"></input>
</html>
