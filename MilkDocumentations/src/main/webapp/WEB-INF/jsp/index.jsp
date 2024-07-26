<%@page import="com.example.MilkDocumentations.entity.MilkSupplier"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Milk Supplier Management System</title>
</head>
<body>
    <h1>Milk Supplier Management System</h1>
    
    <table border="1">
        <tr>
            <th>supplier Id</th>
            <th>Firstname</th>
            <th>Middlename</th>
            <th>Lastname</th>
            <th>Email</th>
            <th>Contact number</th>
            <th>Association date</th>
        </tr>
        <% 
            List<MilkSupplier> supplierList = (List<MilkSupplier>) request.getAttribute("suppliers");
            if (supplierList != null) {
                for (MilkSupplier supplier: supplierList) {
        %>
        <tr>
            <td><%= supplier.getId() %></td>
            <td><%= supplier.getFirstName()%></td>
            <td><%= supplier.getMiddleName() %></td>
            <td><%= supplier.getLastName()%></td>
            <td><%= supplier.getEmail() %></td>
            <td><%= supplier.getContactNo() %></td>
            <td><%= supplier.getAssociationDate() %></td>
            
        </tr>
        <% 
                }
            } else {
        %>
        <tr>
            <td colspan="5">No Suppliers found</td>
        </tr>
        <% } %>
    </table>
     <a href="/addSupplier">Add Supplier</a>
</body>
</html>
