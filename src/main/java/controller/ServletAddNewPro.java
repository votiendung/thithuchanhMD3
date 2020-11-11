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

@WebServlet(name = "ServletAddNewPro",urlPatterns = "/create")
public class ServletAddNewPro extends HttpServlet {
    ProductImpl products = new ProductImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double proprice = Double.parseDouble(request.getParameter("price"));
        int proQuantity = Integer.parseInt(request.getParameter("quantity"));
        String proColor = request.getParameter("color");
        String proDes = request.getParameter("des");
        int CategoryID = Integer.parseInt(request.getParameter("cateID"));

        Product product = new Product(name, proprice, proQuantity,proColor,proDes,CategoryID);
        products.addNewPro(product);
//        request.setAttribute("product",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }
}
