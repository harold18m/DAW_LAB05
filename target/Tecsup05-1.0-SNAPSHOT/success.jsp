
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-green-100 font-sans">

<div class="container mx-auto my-8 p-8 bg-white rounded-lg shadow-md">
    <h1 class="text-3xl font-bold text-green-600 mb-4">Added Successfully</h1>

    <h3 class="text-lg text-green-600">Filas afectadas: <%=request.getAttribute("rowsaffected")%></h3>
</div>
<div class="container mx-auto my-8 p-8 bg-white rounded-lg shadow-md">
    <a href="index.jsp" class="text-blue-500 hover:underline">Inicio</a>
</div>
</body>
</html>
