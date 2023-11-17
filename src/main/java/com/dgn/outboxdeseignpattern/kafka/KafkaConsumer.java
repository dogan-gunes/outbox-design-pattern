package com.dgn.outboxdeseignpattern.kafka;

import com.dgn.outboxdeseignpattern.model.IQDatabase;
import com.dgn.outboxdeseignpattern.model.OutBoxMessageCDC;
import com.dgn.outboxdeseignpattern.service.IQDatabaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private final IQDatabaseService iqDatabaseService;
    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    ObjectMapper objectMapper = new ObjectMapper();

    public KafkaConsumer(IQDatabaseService iqDatabaseService) {
        this.iqDatabaseService = iqDatabaseService;
    }

    @KafkaListener(
            topics = "outbox.public.table_outbox",
            groupId = "outbox-group"
    )
    public void outboxListener(@Payload OutBoxMessageCDC outBoxMessageCDC, @Headers ConsumerRecord consumerRecord) throws JsonProcessingException {

        String value = (String)outBoxMessageCDC.getAfter().getPayload();
            final IQDatabase payload = objectMapper.readValue(value, IQDatabase.class);
            iqDatabaseService.addIQDatabase(payload);

    }

}
