
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product Register Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<div class="container mx-auto my-8 p-8 bg-white rounded-lg shadow-md">
    <a href="index.jsp" class="text-blue-500 hover:underline">Inicio</a>
</div>

<div class="container mt-4">
    <form action="<%=request.getContextPath()%>/ProductServlet" method="post">

        <div class="mb-3">
            <label for="name" class="form-label">Name :</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>

        <div class="mb-3">
            <label for="category" class="form-label">Category :</label>
            <input type="text" class="form-control" id="category" name="category" required>
        </div>

        <div class="mb-3">
            <label for="amount" class="form-label">Amount :</label>
            <input type="number" class="form-control" id="amount" name="amount" required>
        </div>

        <div class="mb-3">
            <label for="price" class="form-label">Price :</label>
            <input type="number" step="0.01" class="form-control" id="price" name="price" required>
        </div>

        <div class="mb-3">
            <label for="isActive" class="form-label">Is Active :</label>
            <select class="form-select" id="isActive" name="isActive" required>
                <option value="true">True</option>
                <option value="false">False</option>
            </select>
        </div>

        <div class="col-auto">
            <button type="submit" class="btn btn-primary">Add Product</button>
        </div>

    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>
