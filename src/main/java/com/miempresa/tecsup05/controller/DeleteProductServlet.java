package com.miempresa.tecsup05.controller;

import com.miempresa.tecsup05.dao.ProductoDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteProductServlet", value = "/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));

        ProductoDao dao = new ProductoDao();
        try {
            int rowsAffected = dao.deleteProduct(productId);
            if (rowsAffected > 0) {
                response.sendRedirect("ProductListServlet");
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
                request.setAttribute("message", "No se encontró el producto para eliminar");
                requestDispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            request.setAttribute("message", e.getMessage());
            requestDispatcher.forward(request, response);
        }
    }

}
