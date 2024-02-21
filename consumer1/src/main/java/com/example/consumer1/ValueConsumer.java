package com.example.consumer1;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ValueConsumer {
    @Bean
    public Consumer<Message<Thing>> onReceive() {
        return (message) -> {
            System.out.println("Received value in Consumer1: " + message.getPayload());
        };
    }
}
