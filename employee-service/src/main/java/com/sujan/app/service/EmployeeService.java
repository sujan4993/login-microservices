package com.sujan.app.service;

import java.util.List;

import com.sujan.app.model.EmployeeEntity;

public interface EmployeeService {
	
	EmployeeEntity addEmployee(EmployeeEntity employee);
	List<EmployeeEntity> findAllEmployees();
	EmployeeEntity updateEmployee(EmployeeEntity employee);
	EmployeeEntity findEmployeeById(Long id);
	void deleteEmployee(Long id);
}
