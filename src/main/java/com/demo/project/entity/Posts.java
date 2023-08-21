package com.demo.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Posts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String username;
	
	@Column(length = 450)
	private String post;

	public Posts() {
		super();
	}

	public Posts(long id, String username, String post) {
		super();
		this.id = id;
		this.username = username;
		this.post = post;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}
	
	
}
