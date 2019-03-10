/**
 * 
 */
package com.sumit.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sumit.models.User;

/**
 * @author Sumit
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {
	
	User findByUserName(String userName);
	
	User findByUserId(Long userId);
	
	List<User> findAll();
	
	User save(User user);

}
