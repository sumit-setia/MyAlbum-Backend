/**
 * 
 */
package com.sumit.controllers;

import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.models.User;
import com.sumit.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Sumit
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired 
	private UserService userService;
	
	@PostMapping("/login")
	public String login(@RequestBody Map<String,String> json) throws ServletException{
		 if(json.get("username")==null || json.get("password")==null)
		 {
			 throw new ServletException("Please fill in username and password");
		 }
		 String userName =json.get("username");
		 String password = json.get("password");
		 
		 User user = userService.findByUserName(userName);
		 if(user ==null)
		 {
			 throw new ServletException("User does not exist with this name");
		 }
		 String pwd = user.getPassword();
		 if(!password.equals(pwd)) {
			 throw new ServletException("Invalid login details, Please check your username and password");
		 }
		return Jwts.builder().setSubject(userName).claim("roles", "user").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretKey").compact();
	}
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user)
	{
		return userService.save(user);
	}
	
}
