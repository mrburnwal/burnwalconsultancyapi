package tech.burnwall.consultancy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.burnwall.consultancy.Entites.Employee;
import tech.burnwall.consultancy.service.EmployeeService;

@RestController
public class EmployeeControllers {
	
	@Autowired
	private EmployeeService employeeServ;
	
	@RequestMapping("/")
	public String home() {
		return "Welcome to BurnwalConsultancy";
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return this.employeeServ.getEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable String employeeId) {
		return this.employeeServ.getEmployee(Long.parseLong(employeeId));
	}

	@PostMapping("/employees/{employeeId}")
	public Employee updateEmployee(@PathVariable String employeeId, @RequestBody Employee employee) {
		return this.employeeServ.updateEmployee(Long.parseLong(employeeId), employee);
	}
	
	@PutMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		return this.employeeServ.addEmployee(employee);
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public Employee deleteEmployee(@PathVariable String employeeId) {
		return this.employeeServ.deleteEmployee(Long.parseLong(employeeId));
	}
}
