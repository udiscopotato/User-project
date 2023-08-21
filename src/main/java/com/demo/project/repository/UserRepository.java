package com.demo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.project.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
}
