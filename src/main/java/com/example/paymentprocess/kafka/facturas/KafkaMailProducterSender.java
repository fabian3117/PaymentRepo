package com.example.paymentprocess.kafka.facturas;

import com.example.paymentprocess.dto.BodyMail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaMailProducterSender {

    @Value("${spring.kafka.facturac}")
    private String topicF;


    @Autowired
    private KafkaTemplate<String, BodyMail> kafkaTemplate;
    public void send(BodyMail bodyMail) {
        kafkaTemplate.send(topicF, bodyMail);
    }
}
