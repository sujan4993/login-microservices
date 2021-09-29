package com.sujan.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujan.app.exception.BadRequestException;
import com.sujan.app.model.LoginEntity;
import com.sujan.app.repository.LoginRepository;
import com.sujan.app.shared.LoginDto;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRepository repository;

	@Override
	public LoginEntity fetchUserByEmailAndPAsssword(LoginEntity user) throws Exception {
		String tempEmail = user.getEmail();
		String tempPass = user.getPassword();
		LoginEntity userObj = null;
		if(tempEmail != null && tempPass !=null) {
			userObj = repository.findByEmailAndPassword(tempEmail, tempPass);
		}
		if(userObj == null) {
			throw new BadRequestException("Bad credentials");
		}
		return userObj;
	}
	
	
	
	
	

}
