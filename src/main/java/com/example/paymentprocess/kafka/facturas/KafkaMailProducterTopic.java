package com.example.paymentprocess.kafka.facturas;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
@Configuration

public class KafkaMailProducterTopic {

    @Value("${spring.kafka.facturac}")
    private String topicF;

    @Bean
    public NewTopic topicFacturas(){
//        return new NewTopic(topicErrorF, 1, (short) 1);

        return TopicBuilder.name(topicF).build();
    }

}
