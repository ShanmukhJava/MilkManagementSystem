<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Milk Management List</title>
    <style>
        .button {
            background-color: yellow;
            padding: 8px 20px;
            border: none;
            text-decoration: none;
            color: black;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
            display: inline-block;
        }
        .button:hover {
            background-color: #ffcc00; /* lighter shade of yellow on hover */
        }
    </style>
    <script type="text/javascript">
        function confirmDelete(id) {
            if (confirm("Do you really want to delete the record?")) {
                document.getElementById("deleteForm-" + id).submit();
            }
        }
    </script>
</head>
<body>
    <h1>Milk Management List</h1>

    <div>
        <a href="/addMilkManagement" class="button">Add Milk Management</a>
        <a href="/addSupplier" class="button">Add Supplier</a>
    </div>

    <table border="5">
        <thead>
            <tr>
                <th>Id</th>
                <th>Milk Supplier</th>
                <th>Document Type</th>
                <th>Document Number</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="milkManagement" items="${milkManagements}">
                <tr>
                    <td>${milkManagement.id}</td>
                    <td>${milkManagement.milkSupplier.firstName}</td>
                    <td>${milkManagement.documentType.documentType}</td>
                    <td>${milkManagement.documentNumber}</td>
                    <td>${milkManagement.startDate}</td>
                    <td>${milkManagement.endDate}</td>
                    <td>
                        <a href="/editMilkSupplierManagement/${milkManagement.id}">Edit</a>
                        <a href="javascript:void(0);" onclick="confirmDelete(${milkManagement.id})">Delete</a> 
                        <form id="deleteForm-${milkManagement.id}" action="/deleteMilkSupplierManagement/${milkManagement.id}" method="post" style="display:none;">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
