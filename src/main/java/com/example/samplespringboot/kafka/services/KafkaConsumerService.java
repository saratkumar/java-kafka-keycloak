package com.example.samplespringboot.kafka.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    //private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
    @KafkaListener(topics = "kafkaTopic", groupId = "group_id")
    public void consume(String message) {
        System.out.println("$$$$ => Consumed message: %s "+ message);
        //logger.info(String.format("$$$$ => Consumed message: %s", message));
    }

}
