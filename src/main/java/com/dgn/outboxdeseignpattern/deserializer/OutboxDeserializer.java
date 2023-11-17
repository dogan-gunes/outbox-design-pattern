package com.dgn.outboxdeseignpattern.deserializer;

import com.dgn.outboxdeseignpattern.model.OutBoxMessageCDC;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class OutboxDeserializer implements Deserializer<OutBoxMessageCDC> {
    private ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public OutBoxMessageCDC deserialize(String s, byte[] bytes) {
        try {
            return objectMapper.readValue(bytes, OutBoxMessageCDC.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OutBoxMessageCDC deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
