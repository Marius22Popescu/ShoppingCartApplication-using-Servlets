package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//This is  
public class UpdateCart extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.getRequestDispatcher("UpdateCart.jsp").include(request, response); //request the UpdateCar page
        HttpSession session = request.getSession(false);
        String selectedItem = (String) session.getAttribute("itemKey"); //get the selected item name from the UI UpdatedCart.jsp
        
        int qty = Integer.parseInt(request.getParameter("quantity")); //get the quantity from the user output 
        Map<String, Integer> orders = new HashMap<>(); //Create a map in order to store the product and quantity ordered
		session.removeAttribute("map"); 		//remove old data from the session
		orders.put(selectedItem, qty);			//put the item name and desire quantity on the orders map
		session.setAttribute("map", orders);		//set the new attribute for the session to be orders
		request.getRequestDispatcher("Cart.jsp").forward(request, response); //Create an RequestDistpatcher in order to forward to the cart page
		
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
