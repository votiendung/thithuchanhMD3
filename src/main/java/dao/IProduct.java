package dao;

import model.Product;

import java.util.List;

public interface IProduct {
    List<Product> listAllProduct();

    List<Product> searchByCategory(String cateName);

    Product searchProByID(int proID);

    void addNewPro(Product product);

    void editPro(Product product);

    void deletePro(int id);


}
