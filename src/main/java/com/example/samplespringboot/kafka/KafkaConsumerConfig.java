//package com.example.samplespringboot.kafka;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.core.ConsumerFactory;
//
//import java.util.HashMap;
//import java.util.Map;
//
////@EnableKafka
////@Configuration
//public class KafkaConsumerConfig {
//    @Value(value="${kafka.bootstrapAddress}")
//    private String bootstrapAddress;
//
//
//    @Bean
//    public ConsumerFactory<String, String> consumerFactory() {
//        Map<String, String> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
////        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
////        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
////        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
//    }
//}
