package com.mdtalalwasim.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdtalalwasim.springrestapi.entity.Employee;
import com.mdtalalwasim.springrestapi.service.EmployeeService;

@RestController
//@RequestMapping("/api")--this will define in properties file
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Value("${app.name: EMS}")
	private String appName;
	
	@Value("${app.version: v1.0}")
	private String appVersion;
	
	@GetMapping("version")
	public String getAppDetails() {
		return "The App Name : "+appName +" App Version :"+appVersion ;
	}

	// localhost:8080/employees/
	@GetMapping("/employees") 
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}


	// localhost:8080/employees/12 
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable() Long id) {
		return employeeService.getEmployee(id);
	}
	
	// localhost:8080/employees?id=12 
	/*@DeleteMapping("/employees/{id}")
	public String deleteEmployees(@PathVariable("id") Long id) {
		return "Deleting the employees details with id = " + id;
	}*/
	
	//localhost:8080/employees/12
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		System.out.println("Updating the employee data "+id);
		return employee; 
	}
	
	//localhost:8080/employees?id=12 
	@DeleteMapping("/employees")
	public String deleteEmployees(@RequestParam Long id) {
		return "Deleting the employees details with id = "+id;
	}


}
