package model;

public class Product {
    private int proID;
    private String proName;
    private double proPrice;
    private int proQuantity;
    private String proColor;
    private String proDes;
    private int categoryID;
    private String categoryName;

    public Product() {
    }

    public Product(int proID, String proName, double proPrice, int proQuantity, String proColor, String proDes, String categoryName) {
        this.proID = proID;
        this.proName = proName;
        this.proPrice = proPrice;
        this.proQuantity = proQuantity;
        this.proColor = proColor;
        this.proDes = proDes;
        this.categoryName = categoryName;
    }

    public Product(int proID, String proName, double proPrice, int proQuantity, String proColor, String proDes, int categoryID, String categoryName) {
        this.proID = proID;
        this.proName = proName;
        this.proPrice = proPrice;
        this.proQuantity = proQuantity;
        this.proColor = proColor;
        this.proDes = proDes;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public int getProID() {
        return proID;
    }

    public Product(String proName, double proPrice, int proQuantity, String proColor, String proDes, String categoryName) {
        this.proName = proName;
        this.proPrice = proPrice;
        this.proQuantity = proQuantity;
        this.proColor = proColor;
        this.proDes = proDes;
        this.categoryName = categoryName;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public double getProPrice() {
        return proPrice;
    }

    public void setProPrice(double proPrice) {
        this.proPrice = proPrice;
    }

    public int getProQuantity() {
        return proQuantity;
    }

    public void setProQuantity(int proQuantity) {
        this.proQuantity = proQuantity;
    }

    public String getProColor() {
        return proColor;
    }

    public void setProColor(String proColor) {
        this.proColor = proColor;
    }

    public String getProDes() {
        return proDes;
    }

    public void setProDes(String proDes) {
        this.proDes = proDes;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
