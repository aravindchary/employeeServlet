package employeeServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import service.EmployeeService;

/**
 * Servlet implementation class EmployeeCredentials
 */
@WebServlet("/register")
public class EmployeeFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String i=request.getParameter("empid");
		String n=request.getParameter("ename");
		String e=request.getParameter("eemail");
		String d=request.getParameter("edesignation");
		
		/*RequestDispatcher rd=request.getRequestDispatcher("EmployeeSucess.jsp");
		request.setAttribute("empid",i); // to display data in jsp page
		request.setAttribute("ename", n); 
		request.setAttribute("eemail",  e); 
		request.setAttribute("edesignation", d);*/ 
		
		Employee emp = new Employee(i,n,e,d);
		EmployeeService service = new EmployeeService();
		service.save(emp);
		request.setAttribute("successMessage", "Saved employee successfully ..");
		RequestDispatcher rd=request.getRequestDispatcher("employeeDetails.jsp");
		List<Employee> empLsit = service.getAllEmployees();
		request.setAttribute("listOfEmployes", empLsit);
		rd.forward(request, response);		
		
	}

}
