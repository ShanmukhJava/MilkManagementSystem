<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Milk Management</title>
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
	<h1>Add Milk Management</h1>

	<form:form action="/saveMilkManagement" method="post"
		modelAttribute="milkManagement" enctype="multipart/form-data">
		<table>
			<tr>
				<td><form:label path="milkSupplier.id">Milk Supplier:</form:label></td>
				<td><form:select path="milkSupplier.id" id="supplierId">
						<form:options items="${milkSuppliers}" itemValue="id"
							itemLabel="firstName" />
					</form:select></td>
			</tr>

			<tr>
				<td><label for="documentTypeId">Document Type:</label></td>
				<td><form:select path="documentType.id" id="documentTypeId">
						<form:options items="${documentTypes}" itemValue="id"
							itemLabel="documentType" />
					</form:select></td>
			</tr>

			<tr>
				<td><label for="documentNumber">Document Number:</label></td>
				<td><form:input path="documentNumber" id="documentNumber"
						required="required" /></td>
			</tr>

			<tr>
				<td><label for="startDate">Start Date:</label></td>
				<td><form:input path="startDate" id="startDate" type="date"
						required="required" /></td>
			</tr>

			<tr>
				<td><label for="endDate">End Date:</label></td>
				<td><form:input path="endDate" id="endDate" type="date"
						required="required" /></td>
			</tr>

			<tr>
				<td><label for="document">Document:</label></td>
				<td><input type="file" name="document" id="document"
					required="required" /></td>
			</tr>
		</table>

		<button type="submit">Save</button>
	</form:form>
	<script>
        $(document).ready(function() {
            $("#milkManagementForm").validate({
                rules: {
                    "milkSupplier.id": {
                        required: true
                    },
                    "documentType.id": {
                        required: true
                    },
                    documentNumber: {
                        required: true,
                        digits: true
                    },
                    startDate: {
                        required: true,
                        date: true
                    },
                    endDate: {
                        required: true,
                        date: true
                    },
                    document: {
                        required: true
                    }
                },
                messages: {
                    "milkSupplier.id": {
                        required: "Please select a milk supplier"
                    },
                    "documentType.id": {
                        required: "Please select a document type"
                    },
                    documentNumber: {
                        required: "Please enter a document number",
                        digits: "Document number must be digits only"
                    },
                    startDate: {
                        required: "Please enter a start date",
                        date: "Please enter a valid date"
                    },
                    endDate: {
                        required: "Please enter an end date",
                        date: "Please enter a valid date"
                    },
                    document: {
                        required: "Please upload a document"
                    }
                },
                errorElement: "div",
                errorPlacement: function(error, element) {
                    error.addClass("error");
                    error.insertAfter(element);
                }
            });
        });
    </script>
</body>
</html>
