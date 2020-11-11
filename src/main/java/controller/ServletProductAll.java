package controller;

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

@WebServlet(name = "ServletProductAll",urlPatterns = "/product")
public class ServletProductAll extends HttpServlet {
    ProductImpl product = new ProductImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = product.listAllProduct();
        request.setAttribute("listPro", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("prolist.jsp");
        dispatcher.forward(request, response);
    }
}
