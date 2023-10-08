package com.miempresa.tecsup05.controller;

import com.miempresa.tecsup05.model.Producto;
import jakarta.servlet.RequestDispatcher;
import com.miempresa.tecsup05.dao.ProductoDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "EditProductServlet", value = "/EditProductServlet")
public class EditProductServlet extends HttpServlet {

    private ProductoDao dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new ProductoDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int productId = Integer.parseInt(request.getParameter("productId"));

            Producto product = dao.getProductById(productId);

            request.setAttribute("product", product);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/editproduct.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            request.setAttribute("message", e.getMessage());
            requestDispatcher.forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int productId = Integer.parseInt(request.getParameter("productId"));
            String name = request.getParameter("name");
            String category = request.getParameter("category");
            double price = Double.parseDouble(request.getParameter("price"));
            int amount = Integer.parseInt(request.getParameter("amount"));
            boolean isActive = Boolean.parseBoolean(request.getParameter("isActive"));

            Producto editedProduct = new Producto(productId, name, category, price, amount, isActive);

            int rowsAffected = dao.editProduct(editedProduct);

            if (rowsAffected > 0) {
                List<Producto> listProductos = dao.getProducts();
                request.setAttribute("list", listProductos);
                request.setAttribute("message", "Producto editado con éxito");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/listproduct.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
                request.setAttribute("message", "No se pudo editar el producto");
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




