package controller;

import dao.IProduct;
import dao.ProductImpl;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletSearchByCategory",urlPatterns = "/search")
public class ServletSearchByCategory extends HttpServlet {
    IProduct products = new ProductImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("search");
        List<Product> productList = products.searchByCategory(productName);
        request.setAttribute("listPro",productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("searchProductsByName.jsp");
        requestDispatcher.forward(request, response);
    }
}
