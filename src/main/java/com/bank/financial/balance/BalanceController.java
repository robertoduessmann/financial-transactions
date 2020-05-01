package com.bank.financial.balance;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "balance")
public class BalanceController {

  @Autowired
  private BalanceService balanceService;

  @GetMapping("{userId}")
  public ResponseEntity<BalanceDto> getBalance(@PathVariable("userId") UUID userId) {
    return balanceService.getBalance(userId).map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
