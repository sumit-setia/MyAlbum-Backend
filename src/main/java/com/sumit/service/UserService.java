package com.sumit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sumit.models.User;

/**
 * @author Sumit
 *
 */
@Service
public interface UserService {

	List<User> findAllUsers();
	
	User findByUserName(String userName);
	
	User save(User user);
	}
