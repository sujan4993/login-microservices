package com.sujan.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.sujan.app.model.LoginEntity;

public interface LoginRepository extends  CrudRepository<LoginEntity, Long>{

	LoginEntity findByEmailAndPassword(String email, String password);
	
}
