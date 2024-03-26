package com.rabbitmq;

import com.rabbitmq.configuration.RabbitMQConfig;
import com.rabbitmq.reciever.MessageReceiver;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.junit.RabbitAvailable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@SpringBootTest
@RabbitAvailable(queues = RabbitMQConfig.queueName)
class RabbitMQIntegrationTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageReceiver receiver;

    @Test
    void testSendMessage() {
        String testMessage = "Hello RabbitMQ!";
        rabbitTemplate.convertAndSend(RabbitMQConfig.topicExchangeName, "foo.bar.baz", testMessage);

        await().atMost(5, TimeUnit.SECONDS).untilAsserted(() -> receiver.getLatch().await());

        assertThat(receiver.getLatch().getCount()).isZero();
    }
}