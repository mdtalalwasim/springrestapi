package com.mdtalalwasim.springrestapi.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter 
@Getter
@ToString	
@Entity
@Table(name = "tbl_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NotNull(message = "Employee name should not be null!")
	//@NotEmpty(message = "Employee name should not be null!")
	@NotBlank(message = "Employee name should not be null!")
	private String name;
	
	private Long age = 0L;
	
	private String location;
	
	@Email(message = "Please input valid email!")
	private String email;
	
	//@NotNull(message = "Employee Department should not be null!")
	//@NotEmpty(message = "Employee Department should not be null!")
	@NotBlank(message = "Employee Department should not be null!")
	private String department;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at") 
	private Date updatedAt;
	
	
	

}
