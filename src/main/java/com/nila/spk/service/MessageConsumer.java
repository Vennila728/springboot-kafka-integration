package com.nila.spk.service;
import com.nila.spk.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageConsumer {

    @KafkaListener(topics = "sample", groupId = "my-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
