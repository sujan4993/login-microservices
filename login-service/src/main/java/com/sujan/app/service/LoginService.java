package com.sujan.app.service;

import com.sujan.app.model.LoginEntity;
import com.sujan.app.shared.LoginDto;

public interface LoginService {
	//LoginDto getLogin(String email);
	LoginEntity fetchUserByEmailAndPAsssword(LoginEntity user) throws Exception;
	
}
