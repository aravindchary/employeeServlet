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
 * Servlet implementation class UpdateEmployeeServlet
 */
@WebServlet("/updateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String empId=request.getParameter("empid");
		String name=request.getParameter("ename");
		String email=request.getParameter("eemail");
		String desig=request.getParameter("edesignation");
		String id=request.getParameter("id");
		int idVal = Integer.parseInt(id);
		
		Employee emp = new Employee(empId,name,email,desig);
		emp.setId(idVal);
		EmployeeService service = new EmployeeService();
		try {
			service.update(emp);
			RequestDispatcher rd=request.getRequestDispatcher("employeeDetails.jsp");
			System.out.println(rd);
			List<Employee> empLsit = service.getAllEmployees();
			request.setAttribute("listOfEmployes", empLsit);
			request.setAttribute("successMessage", "Successfully updated the employee..");
			rd.forward(request, response);		
		}catch (Exception e) {
			System.out.println("Error while updating employee : "+e.getMessage());
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
