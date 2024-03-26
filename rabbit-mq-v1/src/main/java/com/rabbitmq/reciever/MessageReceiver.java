package com.rabbitmq.reciever;

import com.rabbitmq.configuration.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class MessageReceiver {

    private final CountDownLatch latch = new CountDownLatch(1);

    @RabbitListener(queues = RabbitMQConfig.queueName)
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}

