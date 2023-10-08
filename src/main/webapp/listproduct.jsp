<%@ page import="com.miempresa.tecsup05.model.Producto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Product List</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
<div class="container mx-auto my-8 p-8 bg-white rounded-lg shadow-md">
  <a href="index.jsp" class="text-blue-500 hover:underline">Inicio</a>
</div>

<div class="container mx-auto mt-5 p-5">

  <table class="table-auto w-full bg-white shadow-lg rounded">
    <thead class="bg-gray-200">
    <tr>
        <th class="px-4 py-2">Id</th>
      <th class="px-4 py-2">Name</th>
      <th class="px-4 py-2">Category</th>
      <th class="px-4 py-2">Amount</th>
      <th class="px-4 py-2">Price</th>
      <th class="px-4 py-2">Is Active</th>
      <th class="px-4 py-2">Actions</th>
    </tr>
    </thead>
    <tbody>
    <% List<Producto> listProductos = (List<Producto>) request.getAttribute("list"); %>
    <% for (Producto producto : listProductos) { %>
    <tr class="hover:bg-gray-50">
        <td class="border px-4 py-2"><%= producto.getId() %></td>
      <td class="border px-4 py-2"><%= producto.getName() %></td>
      <td class="border px-4 py-2"><%= producto.getCategory() %></td>
      <td class="border px-4 py-2"><%= producto.getAmount() %></td>
      <td class="border px-4 py-2"><%= producto.getPrice() %></td>
      <td class="border px-4 py-2"><%= producto.isActive() %></td>
      <td class="border px-4 py-2">
        <form action="EditProductServlet" method="get" class="inline-block">
          <input type="hidden" name="productId" value="<%= producto.getId() %>">
          <button type="submit" class="text-blue-500 hover:underline">Edit</button>
        </form>
        <span class="mx-2 text-gray-400">|</span>
        <form action="DeleteProductServlet" method="post" class="inline-block">
          <input type="hidden" name="productId" value="<%= producto.getId() %>">
          <button type="submit" class="text-red-500 hover:underline">Delete</button>
        </form>
      </td>
    </tr>
    <% } %>
    </tbody>
  </table>
</div>
</body>
</html>
