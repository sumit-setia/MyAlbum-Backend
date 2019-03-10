/**
 * 
 */
package com.sumit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumit.Dao.UserDao;
import com.sumit.models.User;

/**
 * @author Sumit
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(userName);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

}
