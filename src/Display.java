import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import a1.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a_c=request.getParameter("a_c");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","prakalpa");
			Statement st=con.createStatement();
			PreparedStatement ps=con.prepareStatement("Select banking.transaction.own_acc, banking.transaction.date, banking.transaction.amount, banking.transaction.to_acc, banking.transaction.type" + 
			" From banking.transaction where banking.transaction.own_acc = '"+a_c+"'");
			ResultSet rs=ps.executeQuery();
		    ArrayList<Account> books=new ArrayList<Account>();
		    while(rs.next())
		    {
		        Account b= new Account();
		        b.own_acc=rs.getInt("own_acc");
		        b.type=rs.getString("type");
		        b.to_acc=rs.getInt("to_acc");
		        b.amount=rs.getInt("amount");
		        b.date=rs.getString("date");
		        books.add(b);
		    }
		    request.setAttribute("account_details",books);
		    con.close();

		    RequestDispatcher rd=request.getRequestDispatcher("/display1.jsp");
		    rd.forward(request,response);
		}
	catch(Exception e)
			{
				System.out.println(e.toString());
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
