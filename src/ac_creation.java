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
 * Servlet implementation class ac_creation
 */
@WebServlet("/ac_creation")
public class ac_creation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ac_creation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("uid");
		String name=request.getParameter("name");
		String password=request.getParameter("pwd");
		String dob=request.getParameter("dob");
		String address=request.getParameter("text");
		String email=request.getParameter("email");
		String type=request.getParameter("slt");
		long acc_no = Math.round(Math.random()*10000000);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","prakalpa");
			RequestDispatcher rd;
			Statement st=con.createStatement();
			String sql="insert into login values('"+username+"','"+password+"')";
			st.executeUpdate(sql);
			String sql1="insert into user_details(name,username,dob,address,email,acc_no,type) values('"+name+"','"+username+"','"+dob+"','"+address+"','"+email+"','"+acc_no+"','"+type+"')";
			int n=st.executeUpdate(sql1);
			if(n>0){
				request.setAttribute("Created","Account Sucessfully Created");
				rd=request.getRequestDispatcher("/default.jsp");
				rd.forward(request,response);
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
