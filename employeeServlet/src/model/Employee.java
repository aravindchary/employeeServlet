package model;

public class Employee {

	private int id;
	private String empId;
	private String name;
	private String email;
	private String designation;
	private int salary;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee(String empId, String name, String email, String designation) {
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.designation = designation;
	}
	
	public Employee() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "[ id : " + this.id + ", firstName : " + this.name + ",Eamil : " + this.email + "]";
	}

}
