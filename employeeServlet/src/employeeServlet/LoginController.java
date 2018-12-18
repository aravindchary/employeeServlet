package employeeServlet;	

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import service.EmployeeService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(
		description = "To open Login page", 
 		urlPatterns = { "/loginServlet" }, 
 		initParams = { 
 				@WebInitParam(name = "Username", value = "admin", description = "user name"), 
 			@WebInitParam(name = "Password", value = "password", description = "password")
 		})


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String n=request.getParameter("userName");
		String p=request.getParameter("userPass");
		
		if(p.equals("admin")&& n.equals("admin")) {
			
			RequestDispatcher rd=request.getRequestDispatcher("employeeDetails.jsp");
			request.setAttribute("userName", n); // to display data in jsp page
			EmployeeService empService = new EmployeeService();
			List<Employee> empList = empService.getAllEmployees();
			request.setAttribute("listOfEmployes", empList);
			rd.forward(request, response);
		}else {
		//	out.println("<h3 style='color:red;'>UserName or Password is incorrect..</h3>");  //1
			request.setAttribute("msg", "UserName or Password is incorrect.."); 
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  //2
			rd.include(request, response);
			// here including two responses.
		}
		
		
		
		
		
		/*ServletConfig sconfig = getServletConfig();
		System.out.println(" Init params : "+sconfig.getInitParameter("Username") + ", Password is : "+sconfig.getInitParameter("Password"));
		
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
