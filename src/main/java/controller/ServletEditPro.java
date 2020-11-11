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

@WebServlet(name = "ServletEditPro",urlPatterns = "/edit")
public class ServletEditPro extends HttpServlet {
    ProductImpl products = new ProductImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("ProName");
        double ProPrice = Double.parseDouble(request.getParameter("ProPrice"));
        int ProQuantity = Integer.parseInt(request.getParameter("ProQuantity"));
        String ProColor = request.getParameter("ProColor");
        String ProDes = request.getParameter("ProDes");
        String Category = request.getParameter("Category");

        Product product = new Product(id,name,ProPrice,ProQuantity,ProColor,ProDes,Category);
        products.editPro(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = products.searchProByID(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);
    }
}
