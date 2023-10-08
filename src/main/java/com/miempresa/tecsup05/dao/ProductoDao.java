package com.miempresa.tecsup05.dao;

import com.miempresa.tecsup05.dao.mysql.MySqlConnection;
import com.miempresa.tecsup05.model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao {

    public int addProduct(Producto producto) throws Exception {

        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection con = mySQLConnection.getConnection();
        int rowsAffected = 0;

        String queryInsert = "INSERT INTO PRODUCTOS (name, category, amount, price, isActive) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, producto.getName());
            ps.setString(2, producto.getCategory());
            ps.setInt(3, producto.getAmount());
            ps.setDouble(4, producto.getPrice());
            ps.setBoolean(5, producto.isActive());

            rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                // Recuperar el ID generado automáticamente
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        System.out.println("ID generado: " + generatedId);
                    } else {
                        System.out.println("No se pudo obtener el ID generado.");
                    }
                }
            }
        }
        return rowsAffected;
    }


    public List<Producto> getProducts() throws Exception {

        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection con = mySQLConnection.getConnection();

        String querySelect = "SELECT id, name, category, amount, price, isActive FROM PRODUCTOS";
        try (Statement st = con.createStatement();
             ResultSet resultSet = st.executeQuery(querySelect)) {

            List<Producto> listProducts = new ArrayList<>();

            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setId(resultSet.getInt("id"));
                producto.setName(resultSet.getString("name"));
                producto.setCategory(resultSet.getString("category"));
                producto.setAmount(resultSet.getInt("amount"));
                producto.setPrice(resultSet.getDouble("price"));
                producto.setActive(resultSet.getBoolean("isActive"));
                listProducts.add(producto);
            }
            return listProducts;
        }
    }


    public int editProduct(Producto producto) throws Exception {
        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection con = mySQLConnection.getConnection();
        int rowsAffected = 0;

        String queryUpdate = "UPDATE PRODUCTOS SET name=?, category=?, amount=?, price=?, isActive=? WHERE id=?";

        try (PreparedStatement ps = con.prepareStatement(queryUpdate)) {
            ps.setString(1, producto.getName());
            ps.setString(2, producto.getCategory());
            ps.setInt(3, producto.getAmount());
            ps.setDouble(4, producto.getPrice());
            ps.setBoolean(5, producto.isActive());
            ps.setInt(6, producto.getId());

            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }
    public Producto getProductById(int productId) throws Exception {
        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection con = mySQLConnection.getConnection();

        String querySelectById = "SELECT * FROM PRODUCTOS WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(querySelectById)) {
            ps.setInt(1, productId);

            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    Producto producto = new Producto();
                    producto.setId(resultSet.getInt("id"));
                    producto.setName(resultSet.getString("name"));
                    producto.setCategory(resultSet.getString("category"));
                    producto.setAmount(resultSet.getInt("amount"));
                    producto.setPrice(resultSet.getDouble("price"));
                    producto.setActive(resultSet.getBoolean("isActive"));
                    return producto;
                }
            }
        }
        return null;
    }
    public int deleteProduct(int productId) throws Exception {
        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection con = mySQLConnection.getConnection();
        int rowsAffected = 0;

        String queryDelete = "DELETE FROM PRODUCTOS WHERE id=?";

        try (PreparedStatement ps = con.prepareStatement(queryDelete)) {
            ps.setInt(1, productId);

            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }
}
