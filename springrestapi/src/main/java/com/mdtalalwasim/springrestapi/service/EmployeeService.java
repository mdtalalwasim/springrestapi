package com.mdtalalwasim.springrestapi.service;

import java.util.List;
import java.util.Optional;

import com.mdtalalwasim.springrestapi.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getEmployees();
	
	Employee saveEmployee(Employee employee);
	
	Employee getEmployee(Long id);
	
	void deleteEmployee(Long id);
	
	Employee updateEmployee(Employee employee);
	
	List<Employee> getEmployeeByName(String name);
	
	List<Employee> getEmployeeByNameAndLocation(String name, String location);

}
