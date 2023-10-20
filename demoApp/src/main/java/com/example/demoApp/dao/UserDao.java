package com.example.demoApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demoApp.dto.User;
import com.example.demoApp.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) 
	{
		return userRepository.save(user);
	}

	public User getUserById(int id) 
	{
		Optional<User> optional = userRepository.findById(id);

		if (optional.isPresent()) 
		{
			return optional.get();
		}
		return null;
	}

	public List<User> getAllUsers() 
	{
		return userRepository.findAll();
	}

	public boolean deleteUserById(int id) 
	{
		User user = getUserById(id);
		if (user != null) 
		{
			userRepository.deleteById(id);
			return true;
		} else
			return false;
	}

	public User updateUserById(int id, User user) 
	{
		User existingUser = getUserById(id);
		if (existingUser != null) 
		{
			userRepository.save(user);
			return user;
		}
		return null;
	}
}
