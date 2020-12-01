package com.example.employee_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value = "/details")
public class EmployeeRestController {

	@Autowired
	EmployeeServices empServ;

	// ---------------retrieve all employee---------------------------

	@GetMapping(value = "/employee")
	public ResponseEntity<List<Employee>> getAllEmployee() {

		List<Employee> employees = empServ.getAllEmployee();

		// if no employee is present
		if (employees.isEmpty()) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	// -------------Retrieve single employee by id ---------------------
	@GetMapping(value = "/employee/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("empId") Long empId) {
		Employee employee = empServ.getEmployee(empId);
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	// --------------------Create new employee--------------------------------
	@PostMapping
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {

		
		Employee employeeExist = empServ.isEmployeeExist(employee.getEmail());
		if (employeeExist!=null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		empServ.addEmployee(employee);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// ---------------------Update existing employee---------------------------
	@PutMapping(value = "/employee/{empId}")
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee, @PathVariable("empId") Long empId) {

		Employee currentEmployee = empServ.getEmployee(empId);

		if (currentEmployee == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		empServ.updateEmployee(employee, empId);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// ------------------Delete employee based on id-------------------------
	@DeleteMapping(value = "/employee/{empId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("empId") Long empId) {

		Employee isEmployeeExist = empServ.getEmployee(empId);

		if (isEmployeeExist == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		empServ.deleteEmployee(empId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}

	// ------------------------Delete all employee-----------------------
	@DeleteMapping(value = "/employee")
	public ResponseEntity<Void> deleteAllEmployee() {
		empServ.deleteAllEmployee();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
