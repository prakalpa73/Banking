

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Transaction
 */
@WebServlet("/Transaction")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transaction() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String credit=request.getParameter("credit");
		String amount=request.getParameter("amount");
		String own_acc=(String)request.getSession().getAttribute("Acc");
		System.out.println(amount);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","prakalpa");
			Statement st=con.createStatement();
			int n=st.executeUpdate("insert into transaction(own_acc,type,to_acc,amount) values("+own_acc+",'debit',"+credit+","+amount+")");
			
			if(n>0)
			{
				st.executeUpdate("insert into transaction(own_acc,type,to_acc,amount) values("+credit+",'credit',"+own_acc+","+amount+")");
			}
			request.setAttribute("SUCCESS","Fund transfer successful...");
			RequestDispatcher rd=request.getRequestDispatcher("transactn.jsp");
			rd.include(request,response);
		}
	catch(Exception e)
			{
				System.out.println(e.toString());
			}
	}

}
