package dao;

import jdbc.JDBCConnection;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements IProduct {
    Connection connection = JDBCConnection.getConnection();

    @Override
    public List<Product> listAllProduct() {
        List<Product> productList = null;
        String SELECT_ALL_PRODUCTS = "SELECT proName,proPrice,proQuantity,proColor,proDes,categoryName FROM products JOIN category ON category.categoryID = products.categoryID ;";
        try {
            productList = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String prodName = rs.getString("proName");
                Double prodPrice = rs.getDouble("proPrice");
                int proQuantity = rs.getInt("proQuantity");
                String proColor = rs.getString("proColor");
                String proDes = rs.getString("proDes");
                String categoryName = rs.getString("categoryName");

                Product product = new Product(prodName, prodPrice, proQuantity, proColor, proDes, categoryName);
                productList.add(product);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> searchByCategory(String cateName) {
        List<Product> productList = null;
        String FIND_PRODUCTS_BY_NAME = "SELECT proName,proPrice,proQuantity,proColor,proDes,categoryName WHERE categoryName like ? ; ";
        List<Product> products = null;
        try {
            products = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCTS_BY_NAME);
            preparedStatement.setString(1, "%" + cateName + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String prodName = rs.getString("proName");
                Double prodPrice = rs.getDouble("proPrice");
                int proQuantity = rs.getInt("proQuantity");
                String proColor = rs.getString("proColor");
                String proDes = rs.getString("proDes");
                String categoryName = rs.getString("categoryName");

                Product product = new Product(prodName, prodPrice, proQuantity, proColor, proDes, categoryName);
                productList.add(product);

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


    @Override
    public Product searchProByID(int proID) {
        String SELECT_PRODUCTS_BY_ID = "SELECT proName,proPrice,proQuantity,proColor,proDes,categoryName FROM products JOIN category ON category.categoryID = products.categoryID WHERE proID=?;";
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_ID);
            preparedStatement.setInt(1,proID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String prodName = rs.getString("proName");
                Double prodPrice = rs.getDouble("proPrice");
                int proQuantity = rs.getInt("proQuantity");
                String proColor = rs.getString("proColor");
                String proDes = rs.getString("proDes");
                String categoryName = rs.getString("categoryName");

                product = new Product(prodName,prodPrice,proQuantity,proColor,proDes,categoryName);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;

    }

    @Override
    public void addNewPro(Product product) {
        String INSERT_USERS_SQL = INSERT_USERS_SQL = "INSERT INTO products" + "  (proName, proPrice, proQuantity,proColor,proDes, categoryName) VALUES " +
                " (?, ?, ?,?,?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            ((PreparedStatement) preparedStatement).setString(1, product.getProName());
            preparedStatement.setDouble(2, product.getProPrice());
            preparedStatement.setInt(3, product.getProQuantity());
            preparedStatement.setString(4, product.getProColor());
            preparedStatement.setString(4, product.getProDes());
            preparedStatement.setString(4, product.getCategoryName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void editPro(Product product) {
        String UPDATE_PRODUCT = "update products set proName = ?, proPrice = ?, proQuantity = ?,proColor=?, proDes = ?, categotyName=? where proID = ? ;";
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_PRODUCT);
            ps.setString(1, product.getProName());
            ps.setDouble(2, product.getProPrice());
            ps.setInt(3, product.getProQuantity());
            ps.setString(4, product.getProColor());
            ps.setString(5, product.getProDes());
            ps.setString(6, product.getCategoryName());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deletePro(int id) {
        String sql = "DELETE product WHERE ProID=? ;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
