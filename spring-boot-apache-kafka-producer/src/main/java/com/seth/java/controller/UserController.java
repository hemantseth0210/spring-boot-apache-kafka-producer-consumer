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
import com.seth.java.service.MessageProducer;

/**
 * @author heseth
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	MessageProducer messageProducer;
	
	
	@GetMapping("/publish/{message}") 
	public String publishMessage(@PathVariable(name = "message") String message) {
		messageProducer.sendMessage(message); 
		return "Published Successfully"; 
	}
	
	@GetMapping("/publish/{message}/partition/{partition}") 
	public String publishPartitionMessage(@PathVariable(name = "message") String message, @PathVariable(name = "partition") int partition) {
		messageProducer.sendMessageToPartion(message, partition); 
		return "Published Successfully"; 
	}
	
	@GetMapping("/publish/{message}/filter") 
	public String publishFilterMessage(@PathVariable(name = "message") String message) {
		messageProducer.sendMessageToFiltered(message); 
		return "Published Successfully"; 
	}
	 
	
	@PostMapping
	public String createUser(@RequestBody User user) {
		messageProducer.send(user);
		return "Published Successfully";
	}

}
