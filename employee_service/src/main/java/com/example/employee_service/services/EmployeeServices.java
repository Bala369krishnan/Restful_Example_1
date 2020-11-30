package com.example.employee_service.services;

import java.util.List;

import com.example.employee_service.model.Employee;

public interface EmployeeServices {

	public List<Employee> getAllEmployee();
	
	public Employee getEmployee(Long empId);
	
	public void addEmployee(Employee emp);
	
	public void updateEmployee(Employee emp , Long empId);
	
	public void deleteEmployee(Long empId);
	
	public void deleteAllEmployee();
	
}
