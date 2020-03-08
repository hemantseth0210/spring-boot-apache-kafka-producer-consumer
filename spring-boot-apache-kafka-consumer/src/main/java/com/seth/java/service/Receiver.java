/**
 * 
 */
package com.seth.java.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.seth.java.domain.User;

/**
 * @author heseth
 *
 */
@Service
public class Receiver {

	@KafkaListener(topics = "demo", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Consumed Message : "+ message);
	}
	
	@KafkaListener(topics = "demo", groupId = "group_json", containerFactory = "userKafkaListenerContainerFactory")
	public void consumeJson(User user) {
		System.out.println("Consumed Json Message : "+ user);
	}
}
