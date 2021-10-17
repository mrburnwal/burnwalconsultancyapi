package tech.burnwall.consultancy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.burnwall.consultancy.Entites.Employee;
import tech.burnwall.consultancy.dao.EmployeeDao;

@Service
public class EmployeeService implements EmployeeServiceImpl {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getEmployees() {
		return (List<Employee>) employeeDao.findAll();
	}

	@Override
	public Employee getEmployee(long employeeId) {
		return employeeDao.findById(employeeId).orElse(null);
	}

	@Override
	public Employee updateEmployee(long employeeId, Employee employee) {
		Employee existingEmployee = employeeDao.findById(employeeId).orElse(null);
		existingEmployee.setFirst_name(employee.getFirst_name());
		existingEmployee.setLast_name(employee.getLast_name());
		existingEmployee.setEmail(employee.getEmail());
		return employeeDao.save(existingEmployee);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public Employee deleteEmployee(long employeeId) {
		Employee e = employeeDao.findById(employeeId).orElse(null);
		employeeDao.deleteById(employeeId);
		System.out.println("Deleted Id  "+ employeeId);
		return e;
	}

}
