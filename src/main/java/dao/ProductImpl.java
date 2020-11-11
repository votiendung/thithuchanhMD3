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
        String SELECT_ALL_PRODUCTS = "SELECT * FROM products JOIN category ON category.categoryID = products.categoryID ";
        try {
            productList = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int proID = rs.getInt("proID");
                String prodName = rs.getString("proName");
                Double prodPrice = rs.getDouble("proPrice");
                int proQuantity = rs.getInt("proQuantity");
                String proColor = rs.getString("proColor");
                String proDes = rs.getString("proDes");
                int categoryID = rs.getInt("products.categoryID");
                String categoryName = rs.getString("categoryName");

                Product product = new Product(proID, prodName, prodPrice, proQuantity, proColor, proDes, categoryID, categoryName);
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
        String FIND_PRODUCTS_BY_NAME = "SELECT * FROM products join category on category.categoryID = products.categoryID WHERE categoryName like ?  ";

        try {
            productList = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCTS_BY_NAME);
            preparedStatement.setString(1, "%" + cateName + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int proID = rs.getInt("proID");
                String prodName = rs.getString("proName");
                Double prodPrice = rs.getDouble("proPrice");
                int proQuantity = rs.getInt("proQuantity");
                String proColor = rs.getString("proColor");
                String proDes = rs.getString("proDes");
                int categoryID = rs.getInt("categoryID");
                String categoryName = rs.getString("categoryName");

                Product product = new Product(proID,prodName, prodPrice, proQuantity, proColor, proDes,categoryID, categoryName);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }


    @Override
    public Product searchProByID(int id) {
        String SELECT_PRODUCTS_BY_ID = "SELECT proName,proPrice,proQuantity,proColor,proDes,categoryName FROM products JOIN category ON category.categoryID = products.categoryID WHERE proID=?";
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String prodName = rs.getString("proName");
                Double prodPrice = rs.getDouble("proPrice");
                int proQuantity = rs.getInt("proQuantity");
                String proColor = rs.getString("proColor");
                String proDes = rs.getString("proDes");
                String categoryName = rs.getString("categoryName");

                product = new Product(id,prodName,prodPrice,proQuantity,proColor,proDes,categoryName);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;

    }

    @Override
    public void addNewPro(Product product) {
        String INSERT_USERS_SQL = "INSERT INTO products(proName, proPrice, proQuantity, proColor, proDes, categoryID) VALUES (?, ?, ?, ?, ?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, product.getProName());
            preparedStatement.setDouble(2, product.getProPrice());
            preparedStatement.setInt(3, product.getProQuantity());
            preparedStatement.setString(4, product.getProColor());
            preparedStatement.setString(5, product.getProDes());
            preparedStatement.setInt(6,product.getCategoryID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void editPro(Product product) {
        String UPDATE_PRODUCT = "update products set proName = ?, proPrice = ?, proQuantity = ?,proColor=?, proDes = ?, categoryID=? where proID = ?";
        String FIND_CATEID_BY_NAME = "select categoryID from category where categoryName = ?";
        int categoryID = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_CATEID_BY_NAME);
            String categoryName = product.getCategoryName();
            ps.setString(1, categoryName );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categoryID = rs.getInt("categoryID");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_PRODUCT);
            String proName =  product.getProName();
            ps.setString(1, product.getProName());
            ps.setDouble(2, product.getProPrice());
            ps.setInt(3, product.getProQuantity());
            ps.setString(4, product.getProColor());
            ps.setString(5, product.getProDes());
            ps.setInt(6, categoryID);

            ps.setInt(7, product.getProID());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deletePro(int id) {
        String sql = "DELETE FROM products WHERE ProID=? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
