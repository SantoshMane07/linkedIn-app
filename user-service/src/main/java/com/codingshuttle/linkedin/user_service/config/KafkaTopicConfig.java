package com.codingshuttle.linkedin.user_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic sendConnectionRequestTopic() {
        return new NewTopic("user-created-topic", 3, (short) 1);
    }

}
