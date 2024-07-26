<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.example.MilkDocumentations.entity.MilkSupplierManagement"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Milk Management</title>
</head>
<body>
	<h1>Edit Milk Management</h1>

		<form:form action="/updateMilkSupplierManagement/${milkManagement.id}"
		method="post" modelAttribute="milkManagement"
		enctype="multipart/form-data">
		<h2>Update Details</h2>
		<table>
			<tr>
				<td><label for="milkSupplier">Milk Supplier:</label></td>
				<td><form:select path="milkSupplier.id" id="milkSupplierId">
						<form:options items="${milkSuppliers}" itemValue="id"
							itemLabel="name" />
					</form:select></td>
			</tr>
			<tr>
				<td><label for="documentType">Document Type:</label></td>
				<td><form:select path="documentType.id" id="documentTypeId">
						<form:options items="${documentTypes}" itemValue="id"
							itemLabel="documentType" />
					</form:select></td>
			</tr>
			<tr>
				<td><label for="documentNumber">Document Number:</label></td>
				<td><form:input path="documentNumber" id="documentNumber"
						value="${milkManagement.documentNumber}" required="required" /></td>
			</tr>
			<tr>
				<td><label for="startDate">Start Date:</label></td>
				<td><form:input path="startDate" id="startDate" type="date"
						value="${milkManagement.startDate}" required="required" /></td>
			</tr>
			<tr>
				<td><label for="endDate">End Date:</label></td>
				<td><form:input path="endDate" id="endDate" type="date"
						value="${milkManagement.endDate}" required="required" /></td>
			</tr>
			<tr>
				<td><label for="document">Document:</label></td>
				<td><input type="file" id="document" name="document"
					/></td>
			</tr>


			<tr>
				<td>Existing image</td>
				<td><img src="/images/${milkManagement.photoName} "
					alt="Example Image" height="300" style="border-radius: 10px">
				</td>
			</tr>
			<tr>

				<td colspan="12"><a href="/MilkSupplierManagementList">View All
						Milk Management Records</a></td>
			</tr>
		</table>
		<button type="submit">Update</button>
	</form:form>
</body>
</html>
 