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
        String name = request.getParameter("ProName");
        double ProPrice = Double.parseDouble(request.getParameter("ProPrice"));
        int ProQuantity = Integer.parseInt(request.getParameter("ProQuantity"));
        String ProColor = request.getParameter("ProColor");
        String ProDes = request.getParameter("ProDes");
        String Category = request.getParameter("Category");

        Product product = new Product(name, ProPrice, ProQuantity,ProColor,ProDes,Category);
        products.addNewPro(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }
}
