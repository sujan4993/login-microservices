package com.sujan.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sujan.app.model.LoginEntity;
import com.sujan.app.service.LoginService;
import com.sujan.app.shared.LoginDto;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private LoginService service;
	
	@GetMapping("/status/check")
	public String status() {
		return "Working on port " + env.getProperty("server.port");
	}
	
	@PostMapping("")
	public LoginEntity loginUser(@RequestBody LoginEntity user) throws Exception{
		return service.fetchUserByEmailAndPAsssword(user);
		
	}

}
