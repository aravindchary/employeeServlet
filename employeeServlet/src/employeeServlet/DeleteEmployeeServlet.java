package employeeServlet;

import java.io.IOException;
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
 * Servlet implementation class deleteEmployeeServlet
 */
@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("employeeId");
		int idVal = Integer.parseInt(id);
		EmployeeService service = new EmployeeService();
		boolean deleteStatus = service.delete(idVal);
		
		if(deleteStatus) {
			request.setAttribute("successMessage", "Successfully deleted employee..");
		}else {
			request.setAttribute("errorMessage", "Not able to find the employee");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("employeeTable.jsp");
		List<Employee> empLsit = service.getAllEmployees();
		request.setAttribute("listOfEmployes", empLsit);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
