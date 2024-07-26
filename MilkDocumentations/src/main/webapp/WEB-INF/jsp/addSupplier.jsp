<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Milk Supplier</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Include jQuery library -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Include jQuery Validation plugin -->
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.19.3/jquery.validate.min.js"></script>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Add Milk Supplier</h1>
        <form:form action="/add" method="post" modelAttribute="milkSupplier" id="milkSupplierForm" class="needs-validation" novalidate>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="firstName">First Name:</label>
                    <form:input path="firstName" id="firstName" class="form-control" required="required"/>
                </div>
                <div class="form-group col-md-6">
                    <label for="middleName">Middle Name:</label>
                    <form:input path="middleName" id="middleName" class="form-control"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="lastName">Last Name:</label>
                    <form:input path="lastName" id="lastName" class="form-control" required="required"/>
                </div>
                <div class="form-group col-md-6">
                    <label for="email">Email:</label>
                    <form:input path="email" id="email" class="form-control" required="required" email="true"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="associationDate">Association Date:</label>
                    <form:input path="associationDate" id="associationDate" type="date" class="form-control" required="required"/>
                </div>
                <div class="form-group col-md-6">
                    <label for="contactNo">Contact Number:</label>
                    <form:input path="contactNo" id="contactNo" class="form-control" required="required" pattern="\d{10}"/>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Add Supplier</button>
        </form:form>
    </div>

    <script>
        $(document).ready(function() {
            $("#milkSupplierForm").validate({
                rules: {
                    firstName: {
                        required: true
                    },
                    lastName: {
                        required: true
                    },
                    email: {
                        required: true,
                        email: true
                    },
                    associationDate: {
                        required: true,
                        date: true
                    },
                    contactNo: {
                        required: true,
                        digits: true,
                        minlength: 10,
                        maxlength: 10
                    }
                },
                messages: {
                    firstName: {
                        required: "Please enter the first name"
                    },
                    lastName: {
                        required: "Please enter the last name"
                    },
                    email: {
                        required: "Please enter an email address",
                        email: "Please enter a valid email address"
                    },
                    associationDate: {
                        required: "Please enter the association date",
                        date: "Please enter a valid date"
                    },
                    contactNo: {
                        required: "Please enter the contact number",
                        digits: "Please enter a valid contact number",
                        minlength: "Contact number must be 10 digits",
                        maxlength: "Contact number must be 10 digits"
                    }
                },
                errorElement: "div",
                errorPlacement: function(error, element) {
                    error.addClass("error");
                    error.insertAfter(element);
                },
                highlight: function(element) {
                    $(element).addClass('is-invalid');
                },
                unhighlight: function(element) {
                    $(element).removeClass('is-invalid');
                }
            });
        });
    </script>
    <!-- Include Bootstrap JS and dependencies -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
