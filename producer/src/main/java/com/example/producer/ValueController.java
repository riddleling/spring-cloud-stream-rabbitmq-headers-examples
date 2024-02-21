package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueController {
    @Autowired
    private StreamBridge streamBridge;

    @PostMapping("/thing1")
    public ResponseEntity<String> thing(@RequestBody Thing thing) {
        Message<Thing> m = MessageBuilder.withPayload(thing)
                .setHeader("some-header", "some-value")
                .build();
        System.out.println("Sending value to topic: " + m);
        streamBridge.send("test-thing-topic", m);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/thing2")
    public ResponseEntity<String> thing2(@RequestBody Thing thing) {
        Message<Thing> m = MessageBuilder.withPayload(thing)
                .setHeader("some-header", "some-value")
                .setHeader("some-header2", "some-value2")
                .build();
        System.out.println("Sending value to topic: " + m);
        streamBridge.send("test-thing-topic", m);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/thing3")
    public ResponseEntity<String> thing3(@RequestBody Thing thing) {
        Message<Thing> m = MessageBuilder.withPayload(thing)
                .setHeader("some-header3", "some-value3")
                .build();
        System.out.println("Sending value to topic: " + m);
        streamBridge.send("test-thing-topic", m);
        return ResponseEntity.ok("ok");
    }
}
