package com.arturfrimu.kafkaproducerv1.controller;

import com.arturfrimu.kafkaproducerv1.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class MainController {

    KafkaProducer kafkaProducer;

    @PostMapping
    public ResponseEntity<Void> send(@RequestBody final String message) {
        log.info("Sent message: " + message);
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok().build();
    }
}