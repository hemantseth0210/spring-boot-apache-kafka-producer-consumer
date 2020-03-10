/**
 * 
 */
package com.seth.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.seth.java.domain.User;

/**
 * @author heseth
 *
 */
@Service
public class MessageProducer {
	
	 @Autowired
     private KafkaTemplate<String, String> kafkaTemplate;
	
	 @Autowired
	 private KafkaTemplate<String, User> userKafkaTemplate;
	
	 @Value("${topic.name}")
	 private String topic;
	 
	 @Value(value = "${message.topic.name}")
	 private String messagetopicName;
	 
	 @Value(value = "${partitioned.topic.name}")
     private String partionedTopicName;

     @Value(value = "${filtered.topic.name}")
     private String filteredTopicName;

     	
	/*
	 * public void send(String message) { kafkaTemplate.send(topic, message); }
	 */
	
	public void send(User user) {
		userKafkaTemplate.send(topic, user);
	}
	
	public void sendMessage(String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(messagetopicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata()
                    .offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });
    }
	
	public void sendMessageToPartion(String message, int partition) {
        kafkaTemplate.send(partionedTopicName, partition, null, message);
    }

    public void sendMessageToFiltered(String message) {
        kafkaTemplate.send(filteredTopicName, message);
    }
}
