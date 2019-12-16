package com.bank.financialtransactions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionConsumer {

    private final Logger logger = LoggerFactory.getLogger(TransactionConsumer.class);
    private static final String TOPIC = "financial-transactions";

    @KafkaListener(topics = TOPIC, groupId = "group_id")
    public void consume(String message) {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}
