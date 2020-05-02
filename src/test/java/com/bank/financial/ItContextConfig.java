package com.bank.financial;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.PostgreSQLContainer;

@ContextConfiguration(initializers = ItContextConfig.Initializer.class)
@Slf4j
public class ItContextConfig {

  public static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:12.2")
      .withDatabaseName("financial");
  public static KafkaContainer kafka = new KafkaContainer();


  public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext context) {
      startup();
      System.setProperty("DB_URL", postgres.getContainerIpAddress());
      System.setProperty("DB_PORT", postgres.getMappedPort(PostgreSQLContainer.POSTGRESQL_PORT).toString());
      System.setProperty("DB_USERNAME", postgres.getUsername());
      System.setProperty("DB_PASSWORD", postgres.getPassword());
      System.setProperty("KAFKA_BOOTSTRAP_SERVERS", kafka.getBootstrapServers());
    }

    private void startup() {
      postgres.start();
      kafka.start();
    }
  }
}