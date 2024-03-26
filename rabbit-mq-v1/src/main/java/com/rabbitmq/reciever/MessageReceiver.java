package com.rabbitmq.reciever;

import com.rabbitmq.configuration.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @RabbitListener(queues = RabbitMQConfig.queueName)
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
    }
}

