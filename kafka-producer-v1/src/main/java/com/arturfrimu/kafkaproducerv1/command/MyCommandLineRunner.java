package com.arturfrimu.kafkaproducerv1.command;

import com.arturfrimu.kafkaproducerv1.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class MyCommandLineRunner implements CommandLineRunner {

    KafkaProducer kafkaProducer;

    @Override
    public void run(String... args) throws InterruptedException {
        int totalMessages = 1000;
        for (int index = 0; index < totalMessages; index++) {
            Thread.sleep(200);
            kafkaProducer.sendMessage(String.valueOf(index), "Message %s".formatted(index));
        }
    }
}
