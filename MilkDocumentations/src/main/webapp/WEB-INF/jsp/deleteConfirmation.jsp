<!DOCTYPE html>
<html>
<head>
    <title>Delete Confirmation</title>
</head>
<body>
<h2>Are you sure you want to delete this Milk Management record?</h2>
<c:url var="deleteUrl" value="/deleteMilkManagement">
    <c:param name="id" value="${milkManagement.id}" />
</c:url>
<form action="<c:out value='${deleteUrl}' />" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="Yes, Delete">
</form>
</body>
</html>
