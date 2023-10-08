package com.miempresa.tecsup05.controller;

import com.miempresa.tecsup05.dao.ProductoDao;
import com.miempresa.tecsup05.model.Producto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addproduct.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductoDao dao = new ProductoDao();
        int rowsAffected = 0;

        Producto producto = new Producto();
        producto.setName(request.getParameter("name"));
        producto.setCategory(request.getParameter("category"));
        producto.setAmount(Integer.parseInt(request.getParameter("amount")));
        producto.setPrice(Double.parseDouble(request.getParameter("price")));
        producto.setActive(Boolean.parseBoolean(request.getParameter("isActive")));

        try {
            rowsAffected = dao.addProduct(producto);
            if (rowsAffected > 0) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success.jsp");
                request.setAttribute("rowsaffected", rowsAffected);
                requestDispatcher.forward(request, response);
            }
        } catch (Exception e) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            request.setAttribute("message", e);
            requestDispatcher.forward(request, response);
            e.printStackTrace();
        }
    }
}
