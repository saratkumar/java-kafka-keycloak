package com.example.samplespringboot.kafka.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducerService {
//    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC = "kafkaTopic";

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
//        this.kafkaTemplate.send(TOPIC, message);
//        logger.info(String.format("$$$$ => Producing message: %s", message));
        System.out.println("$$$$ => Producing message: %s "+ message);
        ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(TOPIC, message);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
//                logger.info("Unable to send message=[ {} ] due to : {}", message, ex.getMessage());
                System.out.println("error "+ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
//                logger.info("Sent message=[ {} ] with offset=[ {} ]", message, result.getRecordMetadata().offset());
                System.out.println("success:" + message);
            }
        });
    }
}
