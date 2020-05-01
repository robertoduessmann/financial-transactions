package com.bank.financial.balance;

import com.bank.financial.entity.Balance;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BalanceDto {

  private UUID userId;
  private BigDecimal amount;

  public static BalanceDto of(Balance balance) {
    return new BalanceDto(balance.getUserId(), balance.getAmount());
  }
}