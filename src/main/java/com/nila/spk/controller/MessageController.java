package com.nila.spk.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.nila.spk.model.Message;
import com.nila.spk.service.MessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
@RestController
@AllArgsConstructor
public class MessageController {
    private final MessageProducer messageProducer;

    @PostMapping("/sentmessage/{topic}")
    public ResponseEntity<String> sentMessage(@PathVariable String topic, @RequestBody Message message) throws JsonProcessingException {
        if (Objects.isNull(message)) return ResponseEntity.badRequest().body("Invalid message or topic");
        return ResponseEntity.ok(messageProducer.sentMessage(topic, message));
    }
}
