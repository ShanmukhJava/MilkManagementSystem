<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Entities</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>List of Entities</h1>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Association Date</th>
                <th>Contact No</th>
                <th>Gender</th>
                <th>Country</th>
                <th>Profile Picture</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="entity" items="${entities}">
                <tr>
                    <td>${entity.id}</td>
                    <td>${entity.firstName}</td>
                    <td>${entity.lastName}</td>
                    <td>${entity.email}</td>
                    <td>${entity.associationDate}</td>
                    <td>${entity.contactNo}</td>
                    <td>${entity.gender}</td>
                    <td>${entity.country}</td>
                    <td><img src="${entity.profilePicturePath}" width="50" height="50"/></td>
                    <td>
                        <a href="/entities/edit/${entity.id}">Edit</a> |
                        <a href="/entities/delete/${entity.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
