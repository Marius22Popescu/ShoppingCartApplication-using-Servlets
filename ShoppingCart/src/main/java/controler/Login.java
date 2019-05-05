package controler;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("text/html"); //set the context type file for the response
		PrintWriter pw=res.getWriter();
		String username = req.getParameter("uname"); //get the user name from the UI
		String password = req.getParameter("pwd"); //get the password from the UI
		String passwordDB = "";				//create a variable in order to get the password from db 
		Statement st;
		//get the user name and password from Db
		try {
			//Create connection to the database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingCartDB?serverTimezone=UTC","root", "M442333244m");
			//Create prepared statement, result set, get password from database
			PreparedStatement preparedStatement = con.prepareStatement("select password from Users where uName = ?");
		    preparedStatement.setString(1, username);
		    ResultSet resultSet = preparedStatement.executeQuery();
		    if (resultSet!= null) {
	            resultSet.next();
	            passwordDB = resultSet.getString("password");   //get the password from DB
		    }
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL exception at LOG IN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			req.getRequestDispatcher("Failure.jsp").forward(req, res);
		}
		//If the user/password is correct go to Products.jsp page
		if (password.equals(passwordDB)) { //compare password from UI with password from DB
			HttpSession session = req.getSession(); //create session
			Map<String, Integer> inventory = new HashMap<>(); //Create a map in order to get data from DB and pass forward to DisplayProducts.jsp

			try {
				//Create connection to the database
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingCartDB?serverTimezone=UTC","root", "M442333244m");
		        PreparedStatement pst = connection.prepareStatement("select pName, price from Products");
		        ResultSet rs = pst.executeQuery();
		        while (rs.next()) {
		            inventory.put(rs.getString("pName"), rs.getInt("price"));
		        }
		        connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL exception at display products");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}		
			
			session.setAttribute("map", inventory); //Add values to the session
			RequestDispatcher rd= req.getRequestDispatcher("DisplayProducts.jsp"); //go to  DisplayProducts.jsp and display inventory
			rd.forward(req, res);	 	
		}
		//If the user/password is wrong go to Failure page again 
		else {
			pw.println("<h3 style='color:red'>Invalid Username or Password!</h>"); //Display Invalid Password 
			req.getRequestDispatcher("Failure.jsp").forward(req, res);	//go to Failure.jsp
			
		}	
	}
	public void doGett(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	doPost(req,res);			
	}
}
