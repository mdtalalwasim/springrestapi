package com.mdtalalwasim.springrestapi.service.impl;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mdtalalwasim.springrestapi.entity.Employee;
import com.mdtalalwasim.springrestapi.repository.EmployeeRepository;
import com.mdtalalwasim.springrestapi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<Employee> getEmployees(int pageNumber, int pageSize) {
		//pagination and sorting both are implemented
		org.springframework.data.domain.Pageable pages = PageRequest.of(pageNumber, pageSize, Direction.DESC, "id");
		return employeeRepository.findAll(pages).getContent();
	}
	
//	//without pagination
//	@Override
//	public List<Employee> getEmployees() {
//		// TODO Auto-generated method stub
//		
//		return employeeRepository.findAll();
//	}


	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}


	@Override
	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}
		return null;
		
	}


	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}


	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getEmployeeByName(String name) {
		return employeeRepository.findByName(name);
	}


	@Override
	public List<Employee> getEmployeeByNameAndLocation(String name, String location) {
		return employeeRepository.findByNameAndLocation(name,location);
	}


	@Override
	public List<Employee> getEmployeeByKeyword(String keyword) {
		//sorting implemented
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		return employeeRepository.findByNameContaining(keyword, sort);
	}


	@Override
	public List<Employee> getEmployeeByAgeGreaterThan(Integer age) {
		return employeeRepository.findByAgeGreaterThan(age);
	}


	@Override
	public List<Employee> getEmployeeByAgeBetween(Integer ageFrom, Integer ageTo) {
		
		return employeeRepository.findByAgeBetween(ageFrom, ageTo);
	}

	@Override
	public List<Employee> getEmployeeByNameOrLocation(String name, String location) {
		// TODO Auto-generated method stub
		return employeeRepository.findEmployeeByNameOrLocation(name, location);
	}

	@Override
	public Integer deleteEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return employeeRepository.deleteEmployeeByName(name);
	}


	
	
	

}
