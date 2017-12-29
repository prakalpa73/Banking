

import java.io.IOException;
import java.sql.Connection;
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
 * Servlet implementation class Credit_card
 */
@WebServlet("/Credit_card")
public class Credit_card extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Credit_card() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String card_no1=request.getParameter("card_no");
		String amount=request.getParameter("amount");
		long card_no = Math.round(Math.random()*1000000);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","prakalpa");
			Statement st=con.createStatement();
			int n=st.executeUpdate("insert into credit_card(card_no,amount) values("+card_no+","+amount+")");
			if(n > 0)
			{
			ResultSet rs=st.executeQuery("Select banking.credit_card.card_no From banking.credit_card Where card_no='"+card_no1+"' AND amount < 100000");
			if(rs.next())
			{
				request.setAttribute("VALID","Transaction approved ;) ");
				RequestDispatcher rd=request.getRequestDispatcher("credit_card.jsp");
				rd.forward(request,response);
			}
			else
			{
				request.setAttribute("INVALID","Transaction rejected :( ");
				RequestDispatcher rd=request.getRequestDispatcher("credit_card.jsp");
				rd.include(request,response);
			}
			}
			else
			{
				System.out.println("Error in inserting...");
			}
			
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
