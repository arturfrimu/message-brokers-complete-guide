package com.arturfrimu.kafkaproducerv1.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KafkaProducerServiceTest {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Test
    void testSendMessage() {
        kafkaProducerService.sendMessage("Hello World!");
    }
}