package com.sujan.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sujan.app.model.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	
	List<EmployeeEntity> findAllByOrderByFirstName();
	
	void deleteEmployeeById(Long id);

	Optional<EmployeeEntity> findEmployeeById(Long id);
}
