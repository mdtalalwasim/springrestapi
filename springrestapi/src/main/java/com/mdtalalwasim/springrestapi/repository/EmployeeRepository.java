package com.mdtalalwasim.springrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdtalalwasim.springrestapi.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByName(String name);
}
