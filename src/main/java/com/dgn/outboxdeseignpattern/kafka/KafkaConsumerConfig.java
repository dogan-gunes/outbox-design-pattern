package com.dgn.outboxdeseignpattern.kafka;

import com.dgn.outboxdeseignpattern.deserializer.OutboxDeserializer;
import com.dgn.outboxdeseignpattern.model.OutBoxMessageCDC;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OutBoxMessageCDC> kafkaListenerContainerFactory(
            ConsumerFactory<String, OutBoxMessageCDC> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, OutBoxMessageCDC> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

    @Bean
    public ConsumerFactory<String, OutBoxMessageCDC> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put("bootstrap.servers", "localhost:29092");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", OutboxDeserializer.class.getName());
        props.put("auto.offset.reset", "earliest");

        return new DefaultKafkaConsumerFactory<>(props);
    }
}
