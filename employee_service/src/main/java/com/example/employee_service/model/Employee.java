package com.example.employee_service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")

//lombok annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeid")
	private long empId;
	
	@Column(name = "first_name")
	@NotBlank // javax validation
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank // javax validation
	private String lastName;
	
	@Column(name = "email")
	@Email // javax validation
	@NotBlank // javax validation
	private String email;
	
}
