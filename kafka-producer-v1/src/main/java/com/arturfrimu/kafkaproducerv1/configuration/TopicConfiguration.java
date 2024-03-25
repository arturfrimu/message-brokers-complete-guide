package com.arturfrimu.kafkaproducerv1.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfiguration {
    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name("nume-topic")
                .partitions(10)
                .replicas(1)
                .build();
    }
}
