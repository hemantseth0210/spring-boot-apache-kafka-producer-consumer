/**
 * 
 */
package com.seth.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seth.java.domain.User;
import com.seth.java.service.Sender;

/**
 * @author heseth
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	Sender sender;
	
	/*
	 * @GetMapping("/publish/{name}") public String
	 * publishMessage(@PathVariable(name = "name") String name) {
	 * sender.send("Hi !! "+ name); return "Published Successfully"; }
	 */
	
	@PostMapping
	public String createUser(@RequestBody User user) {
		sender.send(user);
		return "Published Successfully";
	}

}
