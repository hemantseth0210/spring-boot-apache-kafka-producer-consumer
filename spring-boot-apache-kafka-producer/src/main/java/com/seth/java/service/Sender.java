/**
 * 
 */
package com.seth.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.seth.java.domain.User;

/**
 * @author heseth
 *
 */
@Service
public class Sender {
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	@Value("${topic.name}")
	private String topic;
		
	/*
	 * public void send(String message) { kafkaTemplate.send(topic, message); }
	 */
	
	public void send(User user) {
		kafkaTemplate.send(topic, user);
	}
	
}
