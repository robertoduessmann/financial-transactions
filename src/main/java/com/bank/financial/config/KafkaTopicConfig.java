package com.bank.financial.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

@Component
public class KafkaTopicConfig {

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapAddress;
  @Value("${spring.kafka.topic}")
  private String topic;

  @Bean
  public KafkaAdmin kafkaAdmin() {
    Map<String, Object> props = new HashMap<>();
    props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    return new KafkaAdmin(props);
  }

  @Bean
  public NewTopic configTopic() {
    return new NewTopic(topic, 2, (short) 1);
  }

}
