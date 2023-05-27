package com.mdtalalwasim.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

import jakarta.validation.Valid;

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
	public ResponseEntity<List<Employee>>  getEmployees() {
		System.out.println("Fetching List of Employees...");
		return new ResponseEntity<List<Employee>> (employeeService.getEmployees(), HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee>  saveEmployee(@Valid @RequestBody Employee employee) {
		System.out.println("Save new Employee...");
		return new ResponseEntity<Employee> (employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}


	// localhost:8080/employees/12 
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable() Long id) {
		System.out.println("Fetching Single Employee...");
		return new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.OK);
	}
	
	// localhost:8080/employees?id=12 
	/*@DeleteMapping("/employees/{id}")
	public String deleteEmployees(@PathVariable("id") Long id) {
		return "Deleting the employees details with id = " + id;
	}*/
	
	//localhost:8080/employees/12
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		System.out.println("Updating Employee...");
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK); 
	}
	
	@GetMapping("/employee/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String name){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByName(name), HttpStatus.OK);
	}
	
	
	//localhost:8080/employees?id=12 
	@DeleteMapping("/employees")
	public ResponseEntity<HttpStatus> deleteEmployees(@RequestParam Long id) {
		System.out.println("Deleting Employee...");
		employeeService.deleteEmployee(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	


}
