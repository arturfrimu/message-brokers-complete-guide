package com.arturfrimu.kafkaconsumerv1.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "nume-topic", groupId = "myGroup")
    public void listen(String message) {
        log.info("Received Message in group myGroup: " + message);
    }
}
