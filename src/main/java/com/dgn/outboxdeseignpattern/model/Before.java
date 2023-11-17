package com.dgn.outboxdeseignpattern.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Before {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("aggregate_id")
    private String aggregateId;
    @JsonProperty("aggregate_type")
    private String aggregateType;
    @JsonProperty("message_type")
    private String messageType;
    @JsonProperty("payload")
    private String payload;
    @JsonProperty("create_date")
    private Long createDate;
}
