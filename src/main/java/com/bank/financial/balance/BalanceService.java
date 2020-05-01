package com.bank.financial.balance;

import com.bank.financial.entity.Balance;
import com.bank.financial.entity.Transaction;
import com.bank.financial.repository.BalanceRepository;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {

  @Autowired
  private BalanceRepository balanceRepository;

  public void incrementBalance(Transaction transaction) {
    Balance balance = balanceRepository.findByUserId(transaction.getUserId())
        .orElse(Balance.builder().userId(transaction.getUserId()).amount(BigDecimal.ZERO).build());
    balance.setAmount(balance.getAmount().add(transaction.getAmount()));
    balanceRepository.save(balance);
  }

  public Optional<BalanceDto> getBalance(UUID userId) {
    return balanceRepository.findByUserId(userId).map(BalanceDto::of);
  }
}
