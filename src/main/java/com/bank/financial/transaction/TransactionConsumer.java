package com.bank.financial.transaction;

import com.bank.financial.balance.BalanceService;
import com.bank.financial.entity.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "${spring.kafka.topic}", containerFactory = "transactionKafkaListenerContainerFactory")
public class TransactionConsumer {

    private final Logger logger = LoggerFactory.getLogger(TransactionConsumer.class);

    @Autowired
    private BalanceService balanceService;

    @KafkaHandler
    public void handleTransaction(Transaction transaction) {
        logger.info(String.format("#### -> Consumed message -> %s", transaction));

        balanceService.incrementBalance(transaction);
    }

    @KafkaHandler(isDefault = true)
    public void handleUnsupportedMessages(Object message) {
        logger.debug("Unsupported event received on Financial topic!");
    }
}
