import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("uid");
		String password=request.getParameter("pwd");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","prakalpa");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select banking.login.username, banking.login.password, banking.user_details.acc_no "+
					"From banking.login Inner Join banking.user_details  On banking.user_details.username = banking.login.username where banking.login.username='"+name+"' and banking.login.password='"+password+"'");
			if(rs.next())
			{
				String acc=rs.getString("acc_no");
				request.getSession().setAttribute("Acc",acc);
				RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
				rd.forward(request,response);
			}
			else
			{
				request.setAttribute("INVALID","Username or Password is incorrect");
				RequestDispatcher rd=request.getRequestDispatcher("default.jsp");
				rd.include(request,response);
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
