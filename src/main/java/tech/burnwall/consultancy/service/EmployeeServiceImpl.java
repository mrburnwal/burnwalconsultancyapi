package tech.burnwall.consultancy.service;

import java.util.List;

import tech.burnwall.consultancy.Entites.Employee;

public interface EmployeeServiceImpl {
	
	public List<Employee> getEmployees();
	public Employee getEmployee(long employeeId);
	public Employee updateEmployee(long employeeId, Employee employee);
	public Employee addEmployee(Employee employee);
	public Employee deleteEmployee(long employeeId);
}
