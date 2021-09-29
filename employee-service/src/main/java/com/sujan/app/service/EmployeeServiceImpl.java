package com.sujan.app.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujan.app.exception.UserNotFoundException;
import com.sujan.app.model.EmployeeEntity;
import com.sujan.app.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	public EmployeeEntity addEmployee(EmployeeEntity employee) {
		employee.setUserId(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}

	public List<EmployeeEntity> findAllEmployees() {
		return employeeRepo.findAllByOrderByFirstName();
	}

	public EmployeeEntity updateEmployee(EmployeeEntity employee) {
		EmployeeEntity existEmployee = employeeRepo.findById(employee.getId()).orElse(null);
		existEmployee.setAddress(employee.getAddress());
		existEmployee.setCellPhone(employee.getCellPhone());
		existEmployee.setEmail(employee.getEmail());
		existEmployee.setFirstName(employee.getFirstName());
		existEmployee.setLastName(employee.getLastName());
		existEmployee.setHomePhone(employee.getHomePhone());
		existEmployee.setState(employee.getState());
		existEmployee.setZip(employee.getZip());

		return employeeRepo.save(existEmployee);
	}

	public EmployeeEntity findEmployeeById(Long id) {

		return employeeRepo.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
	}

	public void deleteEmployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}

}
