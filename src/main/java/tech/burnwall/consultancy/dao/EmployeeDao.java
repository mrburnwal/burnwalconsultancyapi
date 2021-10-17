package tech.burnwall.consultancy.dao;

import org.springframework.data.repository.CrudRepository;

import tech.burnwall.consultancy.Entites.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Long>{

}
