package com.bank.financial.transaction;

import com.bank.financial.entity.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionProducer {

    private static final Logger logger = LoggerFactory.getLogger(TransactionProducer.class);

    @Value("${spring.kafka.topic}")
    private String transactionTopic;

    @Autowired
    private KafkaTemplate<String, Transaction> kafkaTemplate;

    public void sendMessage(Transaction transaction) {
        logger.info(String.format("#### -> Producing message -> %s", transaction));
        kafkaTemplate.send(transactionTopic, transaction.getUserId().toString(), transaction);
    }
}
