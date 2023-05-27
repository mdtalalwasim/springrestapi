package com.mdtalalwasim.springrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdtalalwasim.springrestapi.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	//SELECT * FROM tbl_employee WHERE name="Wasim";
	List<Employee> findByName(String name);
	
	//SELECT * FROM tbl_employee WHERE name="Wasim" and location="Bangladesh";
	List<Employee> findByNameAndLocation(String name, String location);
	
	//SELECT * FROM tbl_employee WHERE name LIKE "%asi%";
	List<Employee> findByNameContaining(String keyword);
	
	//List<Employee> findByNameLike(String"%"+keyword+"%");
	
	//SELECT * FROM tbl_employee WHERE age > 20;
	List<Employee> findByAgeGreaterThan(int age);
	
	//SELECT * FROM tbl_employee WHERE age BETWEEN 20 AND 30;
	List<Employee> findByAgeBetween(int ageFrom, int ageTo);
	
}
