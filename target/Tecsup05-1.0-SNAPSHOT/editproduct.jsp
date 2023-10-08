<%@ page import="com.miempresa.tecsup05.model.Producto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">

<div class="container mx-auto mt-5 p-5 bg-white shadow-md rounded-md">
    <h2 class="text-2xl font-semibold mb-5">Edit Product</h2>

    <form action="EditProductServlet" method="post">
        <input type="hidden" name="productId" value="<%= ((Producto) request.getAttribute("product")).getId() %>">

        <div class="mb-4">
            <label for="name" class="block text-sm font-medium text-gray-600">Name:</label>
            <input type="text" id="name" name="name" value="<%= ((Producto) request.getAttribute("product")).getName() %>"
                   class="mt-1 p-2 block w-full border rounded-md bg-gray-100"/>
        </div>

        <div class="mb-4">
            <label for="category" class="block text-sm font-medium text-gray-600">Category:</label>
            <input type="text" id="category" name="category" value="<%= ((Producto) request.getAttribute("product")).getCategory() %>"
                   class="mt-1 p-2 block w-full border rounded-md bg-gray-100"/>
        </div>

        <div class="mb-4">
            <label for="amount" class="block text-sm font-medium text-gray-600">Amount:</label>
            <input type="number" id="amount" name="amount" value="<%= ((Producto) request.getAttribute("product")).getAmount() %>"
                   class="mt-1 p-2 block w-full border rounded-md bg-gray-100"/>
        </div>

        <div class="mb-4">
            <label for="price" class="block text-sm font-medium text-gray-600">Price:</label>
            <input type="number" step="0.01" id="price" name="price" value="<%= ((Producto) request.getAttribute("product")).getPrice() %>"
                   class="mt-1 p-2 block w-full border rounded-md bg-gray-100"/>
        </div>

        <div class="mb-4">
            <input type="checkbox" id="isActive" name="isActive" value="true" <%= ((Producto) request.getAttribute("product")).isActive() ? "checked" : "" %>>
            <label for="isActive" class="ml-2 text-sm font-medium text-gray-600">Is Active</label>
        </div>
        <button type="submit"
                class="px-4 py-2 bg-blue-500 text-white rounded-md hover:bg-blue-600 focus:outline-none focus:ring focus:border-blue-300">
            Save Changes
        </button>
    </form>
</div>

</body>
</html>
