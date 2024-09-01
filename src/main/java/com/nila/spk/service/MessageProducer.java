package com.nila.spk.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nila.spk.model.Message;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public String sentMessage(String topic, Message message) throws JsonProcessingException {
        String msg = new ObjectMapper().writeValueAsString(message.msg);
        kafkaTemplate.send(topic, msg);
        return "Message sent successfully";
    }
}
