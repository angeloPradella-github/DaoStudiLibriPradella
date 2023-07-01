package it.betacom.model;

public class Employee {
	
	private int id, employee_id, dept_id;
	private String first_name, lastName;
	/**
	 * @param id
	 * @param employee_id
	 * @param dept_id
	 * @param first_name
	 * @param lastName
	 */
	public Employee(int id, int employee_id, int dept_id, String first_name, String lastName) {
		this.id = id;
		this.employee_id = employee_id;
		this.dept_id = dept_id;
		this.first_name = first_name;
		this.lastName = lastName;
	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	@Override
	public String toString() {
		return "Employee [id=" + id + ", employee_id=" + employee_id + ", dept_id=" + dept_id + ", first_name="
				+ first_name + ", lastName=" + lastName + "]";
	}
	
}
