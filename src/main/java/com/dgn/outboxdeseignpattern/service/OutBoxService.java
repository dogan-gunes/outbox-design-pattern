package com.dgn.outboxdeseignpattern.service;

import com.dgn.outboxdeseignpattern.model.Account;
import com.dgn.outboxdeseignpattern.model.Outbox;
import com.dgn.outboxdeseignpattern.repository.OutBoxRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
public class OutBoxService {

    private final OutBoxRepository outBoxRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    public OutBoxService(OutBoxRepository outBoxRepository) {
        this.outBoxRepository = outBoxRepository;
    }

    public Outbox addOutBox(Account account) throws JsonProcessingException {

        return outBoxRepository.save(Outbox.builder()
                .aggregateId(String.valueOf(UUID.randomUUID()))
                .createDate(LocalDateTime.now())
                .messageType("Account Created")
                .payload(objectMapper.writeValueAsString(account))
                .aggregateType(Account.class.getName())
                .build());
    }
}
