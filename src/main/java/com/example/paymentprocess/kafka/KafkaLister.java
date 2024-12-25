package com.example.paymentprocess.kafka;

import com.example.paymentprocess.dto.PaymentDTO;
import com.example.paymentprocess.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaLister {

//    @Value("${spring.kafka.topic_notificaciones}")
//    private String topic_cambio_compras;

    @Autowired
    private PaymentService paymentService;

    @KafkaListener(topicPattern = "topic_notificaciones", groupId = "group1")
    void listener(PaymentDTO data) {

        System.out.println(data);
        //--->  Dependiendo si el resultado es OK guardo en db
        paymentService.processPayment(data);
    }
}
