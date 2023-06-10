package com.mdtalalwasim.springrestapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mdtalalwasim.springrestapi.entity.Employee;

@Repository
//public interface EmployeeRepository extends JpaRepository<Employee, Long> {
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	
	
	//SELECT * FROM tbl_employee WHERE name="Wasim";
	List<Employee> findByName(String name);
	
	//SELECT * FROM tbl_employee WHERE name="Wasim" and location="Bangladesh";
	List<Employee> findByNameAndLocation(String name, String location);
	
	//SELECT * FROM tbl_employee WHERE name LIKE "%asi%";
	List<Employee> findByNameContaining(String keyword, Sort sort);
	
	//List<Employee> findByNameLike(String"%"+keyword+"%");
	
	//SELECT * FROM tbl_employee WHERE age > 20;
	List<Employee> findByAgeGreaterThan(int age);
	
	//SELECT * FROM tbl_employee WHERE age BETWEEN 20 AND 30;
	List<Employee> findByAgeBetween(int ageFrom, int ageTo);
	
	
	//JPQL SELECT Query
	@Query("FROM Employee WHERE name= :name OR location =:location")
	List<Employee> findEmployeeByNameOrLocation(String name, String location);
	
	//JPQL Delete Query
	@Modifying
	@Transactional
	@Query("DELETE FROM Employee WHERE name =:name")
	Integer deleteEmployeeByName(String name);// Return Type Integer means : the number of data deleted from database;
	
	
	
	
	//When implement pagination---> otherwise not need! Because JpaRepository will provide it own method.
	Employee save(Employee employee);//When implement pagination
	void deleteById(Long id);//When implement pagination
	Optional<Employee> findById(Long id);//When implement pagination
	
	
	//Native Query Example
	@Query(value ="select * from tbl_employee", nativeQuery = true)
	List<Employee> getAllEmployees();
	
}
