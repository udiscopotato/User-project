package com.demo.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.project.entity.User;
import com.demo.project.entity.UserWrapper;
import com.demo.project.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService user_serv;
	
	@GetMapping("/user/test")
	public String hello() {
		return "Hello Testing ....";
	}
	
	@PostMapping("/user/register")
	public String addUser(@RequestBody User user) {
		return user_serv.userRegister(user);
	}
	
	@PostMapping("/user")
	public String saveUser(@RequestParam("name") String name,
			@RequestParam("mail") String mail,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("image") MultipartFile image) {
		try {
			return user_serv.saveUser(name, mail, username, password, image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAILED";
	}
	
	@PostMapping("/user/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		return user_serv.userLogin(username, password);
	}
	
	@GetMapping("/user/{username}")
	public UserWrapper getUserDetails(@PathVariable("username") String username) {
		try {
			return user_serv.userDetails(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new UserWrapper();
	}
}
