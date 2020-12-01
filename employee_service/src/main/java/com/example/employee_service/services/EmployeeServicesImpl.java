package com.example.employee_service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_service.model.Employee;
import com.example.employee_service.repositories.EmployeeRepository;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

	@Autowired
	EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployee(Long empId) {
		Optional<Employee> findById = empRepo.findById(empId);
		if(!findById.isPresent()) {
			return null;
		}
		return findById.get();
	}

	@Override
	public void addEmployee(Employee emp) {
		empRepo.save(emp);
	}

	@Override
	public void updateEmployee(Employee emp, Long empId) {
		Optional<Employee> findById = empRepo.findById(empId);
		Employee employee = findById.get();
		employee.setEmail(emp.getEmail());
		empRepo.save(employee);
	}

	@Override
	public void deleteEmployee(Long empId) {
		empRepo.deleteById(empId);
	}

	@Override
	public void deleteAllEmployee() {
		empRepo.deleteAll();
	}

	@Override
	public Employee isEmployeeExist(String email) {
		return empRepo.findByEmail(email);
	}
	
}
