package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//This class will handle the registration of new users and is mapped to the sRegister servlet
public class Register extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html"); //set the context type file for the response
		PrintWriter pw=res.getWriter();
		String username = (String)req.getParameter("uname");	//get the user name from the UI
		String password = (String)req.getParameter("pwd");		//get the password from the UI
		String fName = (String)req.getParameter("fname");		//get the first name from the UI
		String lName = (String) req.getParameter("lname");		//get the last name from the UI  
		
		//Create connection to the database
		try {
			//Create connection to the database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingCartDB?serverTimezone=UTC","root", "M442333244m");
			Statement st = (Statement) con.createStatement();
			//Insert user info in the DB
			boolean s = st.execute("insert into Users values('"+username+"', "+"'"+password+"', "+"'"+fName+"', "+"'"+lName+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd= req.getRequestDispatcher("index.jsp"); //Create an RequestDistpatcher in order to forward to the index.js page
		rd.forward(req, res);
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req,res);			
		}
}
