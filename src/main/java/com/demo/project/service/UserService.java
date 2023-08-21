package com.demo.project.service;

import java.sql.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.project.entity.User;
import com.demo.project.entity.UserWrapper;
import com.demo.project.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository user_repo;
	
	public String userRegister(User user) {
		user_repo.save(user);
		return "REGISTERED";
	}
	
	public String saveUser(String name,String mail,String username,String password,MultipartFile file) throws Exception {
		Blob blob = new javax.sql.rowset.serial.SerialBlob(file.getBytes());
		User user = new User();
		user.setName(name);
		user.setMail(mail);
		user.setUsername(username);
		user.setPassword(password);
		user.setImage(blob);
		user_repo.save(user);
		return "SAVED";
	}
	
	public String userLogin(String username, String password) {
		User user = user_repo.findByUsername(username);
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				return "LOGGED IN";
			}
			return "INCORRECT PASSWORD";
		}
		return "not exists";
	}
	
	public UserWrapper userDetails(String username) throws Exception {
		User user = user_repo.findByUsername(username);
		byte [] imageBytes = user.getImage().getBytes(1, (int) user.getImage().length());
		
		UserWrapper wrap = new UserWrapper();
		wrap.setName(user.getName());
		wrap.setMail(user.getMail());
		wrap.setUsername(user.getUsername());
		wrap.setImage(imageBytes);
		return wrap;
	}
}
