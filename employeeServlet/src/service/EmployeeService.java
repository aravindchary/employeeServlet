package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Employee;
public class EmployeeService {

	
	public static Map<Integer,Employee>  map = new HashMap<Integer,Employee>();
	// here instead of DataBase we are using Map
	
	public static int max_value = 1;
	
	static {
		Employee emp = new Employee();
		emp.setId(max_value);
		emp.setEmpId("EMP_1220");
		emp.setDesignation("SBM");
		emp.setEmail("ravi@gmail.com");
		emp.setName("Ravi");
		map.put(emp.getId(), emp);
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee>  empList = new ArrayList<Employee>();
		empList = new ArrayList<Employee>(map.values());   // it will return all values means employee objects as List
		return empList;
	}
	
	public Employee save(Employee emp) {
		max_value = max_value+1;
		emp.setId(max_value);
		map.put(emp.getId(), emp);
		System.out.println("Saved employee successfully...");
		return emp;
	}
	
	public Employee get(int id) {
		Employee emp =  map.get(id);
		return emp;
	}

	
	public Employee update(Employee emp) throws Exception{
		if(emp.getId() == 0) {
			throw new Exception("Emplpoyee id value is not there to update..");
		}
		map.put(emp.getId(), emp); // if you pass duplicate key it will override the value in the map. it is only called update
		return emp;
	}
	
	public boolean delete(int id) {
		
		Employee emp =  map.remove(id);  
		
		 // remove method will return employee object if have key 
		 // it will return null employee object if not found
		
		if(emp == null) {
			return false;
		}else {
			return true;
		}
		
		
	}

	
}
