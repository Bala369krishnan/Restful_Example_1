package com.example.employee_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_service.model.Employee;
import com.example.employee_service.services.EmployeeServices;

@RestController
@RequestMapping(value="/details")
public class EmployeeRestController {

	@Autowired
	EmployeeServices empServ;
	
	
	//get all employee
	
	@GetMapping(value = "/employee")
	public List<Employee> getAllEmployee(){
		return empServ.getAllEmployee();
		
	}
	
	//get employee based on id
	@GetMapping(value = "/employee/{empId}")
	public Employee getEmployee(@PathVariable("empId") Long empId) {
		return empServ.getEmployee(empId);
	}
	
	//create new employee
	@PostMapping
	public void addEmployee(@RequestBody Employee employee) {
		empServ.addEmployee(employee);
	}
	
	
	
	//update existing employee
	@PutMapping(value = "/employee/{empId}")
	public void updateEmployee(@RequestBody Employee employee , @PathVariable ("empId") Long empId) {
		empServ.updateEmployee(employee, empId);
	}
	
	
	//delete employee based on id
	@DeleteMapping(value = "/employee/{empId}")
	public void deleteEmployee(@PathVariable("empId") Long empId) {
		empServ.deleteEmployee(empId);
	}
	
	//delete all employee
	@DeleteMapping(value = "/employee")
	public void deleteAllEmployee() {
		empServ.deleteAllEmployee();
	}
	
}
