package com.arturfrimu.kafkaproducerv1.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KafkaProducerTest {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Test
    void testSendMessage() {
        kafkaProducer.sendMessage("Hello World!");
    }
}