package com.rabbitmq.controller;


import com.rabbitmq.sender.MessageSender;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/api/v1/rabbit")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class RabbitController {

    MessageSender sender;

    @PostMapping
    public ResponseEntity.HeadersBuilder<?> send(@RequestBody String text) {
        sender.send(text);
        return ResponseEntity.noContent();
    }
}
