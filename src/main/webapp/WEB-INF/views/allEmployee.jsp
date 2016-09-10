<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ankit07
  Date: 9/10/16
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Employee List</title>
</head>
<body>
    <h2>List of All Employees</h2>
        <table>
            <tr>
                <td>Name</td><td>Joining Date</td><td>Salary</td><td>SSN</td>
            </tr>
            <c:forEach items = "${employees}" var = "employee">
                <tr>
                    <td>${employee.name}</td>
                    <td>${employee.joiningDate}</td>
                    <td>${employee.salary}</td>
                    <td>${employee.ssn}</td>
                </tr>
            </c:forEach>
        </table>
    <br>
    <a href="<c:url value = '/newEmployee/'/>">Add new Employee</a>
</body>
</html>
