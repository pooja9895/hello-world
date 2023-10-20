package com.example.demoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoApp.dao.UserDao;
import com.example.demoApp.dto.User;

@RestController
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return userDao.saveUser(user);
	}
	
	@GetMapping("/user")
	public User getUser(@RequestParam int id) {
		return userDao.getUserById(id);	
	}
	
	@DeleteMapping("/user")
	public void deleteUserById(@RequestParam int id)
	{
		userDao.deleteUserById(id);
	}
	
	@GetMapping("/alluser")
	public List<User> getAllUser()
	{
		return userDao.getAllUsers();
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestParam int id,@RequestBody User user) {
		return userDao.updateUserById(id, user);
	}
	
//	@PutMapping("/user/{id}")
//	public User updateUser(@RequestBody User user,@PathVariable int id) 
//	{
//		return userDao.updateUserById(id, user);
//	}
}
