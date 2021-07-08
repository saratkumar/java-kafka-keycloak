//package com.example.samplespringboot.kafka;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//
////@Configuration
//public class KafkaProducerConfig {
//
//    @Value(value="${kafka.bootstrapAddress}")
//    private String bootstrapAddress;
//
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
////    @Bean
////    public ProducerFactory<String, String> producerFactory() {
////        Map<String, Object> configProps = new HashMap<>();
////        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
////        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
////        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
////        return new DefaultKafkaProducerFactory<>(configProps);
////    }
//
////    @Bean
////    public KafkaTemplate<String, String> kafkaTemplate() {
////        return new KafkaTemplate<>(producerFactory());
////    }
//
//
//}
//package com.example.samplespringboot.kafka;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//
////@Configuration
//public class KafkaProducerConfig {
//
//    @Value(value="${kafka.bootstrapAddress}")
//    private String bootstrapAddress;
//
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
////    @Bean
////    public ProducerFactory<String, String> producerFactory() {
////        Map<String, Object> configProps = new HashMap<>();
////        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
////        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
////        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
////        return new DefaultKafkaProducerFactory<>(configProps);
////    }
//
////    @Bean
////    public KafkaTemplate<String, String> kafkaTemplate() {
////        return new KafkaTemplate<>(producerFactory());
////    }
//
//
//}
