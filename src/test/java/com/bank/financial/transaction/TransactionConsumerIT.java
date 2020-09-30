package com.bank.financial.transaction;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

import com.bank.financial.ContainersSetupIT;
import com.bank.financial.entity.Transaction;
import com.bank.financial.repository.BalanceRepository;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = ContainersSetupIT.Initializer.class)
class TransactionConsumerIT {

  @Value("${spring.kafka.topic}")
  private String transactionTopic;
  @Autowired
  private KafkaTemplate<String, Transaction> kafkaTemplate;
  @Autowired
  private BalanceRepository balanceRepository;
  @Autowired
  private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

  @BeforeEach
  void setup() {
    kafkaListenerEndpointRegistry.getListenerContainers().forEach(container ->
        ContainerTestUtils.waitForAssignment(container, 2));
  }

  @Test
  void handleTransaction_success() {
    var userId = UUID.randomUUID();
    var amount = BigDecimal.ONE;
    Transaction transaction = Transaction.builder()
        .userId(userId)
        .amount(amount)
        .build();

    kafkaTemplate.send(transactionTopic, transaction.getUserId().toString(), transaction);

    await().atMost(15, TimeUnit.SECONDS).pollInterval(1, TimeUnit.SECONDS)
        .untilAsserted(
            () -> assertThat(balanceRepository.findByUserId(userId).isPresent()).isTrue());
  }

}