
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans">

<div class="container mx-auto my-8 p-8 bg-white rounded-lg shadow-md">
    <h1 class="text-3xl font-bold text-red-600 mb-4">Ha ocurrido un error:</h1>
    <h1 class="text-2xl text-red-600 mb-8">There was a problem with this process</h1>

    <h3 class="text-lg text-red-600">There was an error : <%=request.getAttribute("message")%></h3>
</div>
<div class="container mx-auto my-8 p-8 bg-white rounded-lg shadow-md">
    <a href="index.jsp" class="text-blue-500 hover:underline">Inicio</a>
</div>
</body>
</html>
