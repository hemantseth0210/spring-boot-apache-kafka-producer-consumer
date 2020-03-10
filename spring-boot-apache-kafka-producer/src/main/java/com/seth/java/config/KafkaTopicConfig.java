/**
 * 
 */
package com.seth.java.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

/**
 * Previously we used to run command line tools to create topics in Kafka. 
 * But with the introduction of AdminClient in Kafka, we can now create 
 * topics programmatically.
 *  
 * @author heseth
 *
 */
@Configuration
public class KafkaTopicConfig {
	
	@Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;
	
	@Value("${topic.name}")
	private String topic;
	
	@Value(value = "${message.topic.name}")
	private String messagetopicName;
 
	@Value(value = "${partitioned.topic.name}")
    private String partionedTopicName;

    @Value(value = "${filtered.topic.name}")
    private String filteredTopicName;
    
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }
	
    @Bean
    public NewTopic demoTopic() {
         return new NewTopic("demo", 1, (short) 1);
    }
    
    @Bean
    public NewTopic messageTopic() {
        return new NewTopic(messagetopicName, 1, (short) 1);
    }

    @Bean
    public NewTopic partionedTopic() {
        return new NewTopic(partionedTopicName, 6, (short) 1);
    }

    @Bean
    public NewTopic filteredTopic() {
        return new NewTopic(filteredTopicName, 1, (short) 1);
    }
}
