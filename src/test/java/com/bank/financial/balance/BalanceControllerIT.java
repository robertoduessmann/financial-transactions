package com.bank.financial.balance;


import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import com.bank.financial.ContainersSetupIT;
import com.bank.financial.entity.Balance;
import com.bank.financial.repository.BalanceRepository;
import io.restassured.RestAssured;
import java.math.BigDecimal;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = ContainersSetupIT.Initializer.class)
class BalanceControllerIT {

  @Autowired
  private BalanceRepository balanceRepository;
  @LocalServerPort
  private int serverPort;

  @BeforeEach
  void setup() {
    RestAssured.baseURI = "http://localhost:" + serverPort;
  }

  @Test
  void getBalance_success() {
    var userId = UUID.randomUUID();
    var amount = BigDecimal.TEN;
    balanceRepository.saveAndFlush(Balance.builder().userId(userId).amount(amount).build());

    BalanceDto response = given()
        .when()
        .get("/balance/" + userId.toString())
        .then()
        .statusCode(200)
        .extract()
        .as(BalanceDto.class);

    assertThat(response.getUserId()).isEqualTo(userId);
    assertThat(response.getAmount()).isEqualByComparingTo(amount);
  }

  @Test
  void getBalance_notFound() {
    given()
        .when()
        .get("/balance/" + UUID.randomUUID())
        .then()
        .statusCode(404);
  }
}