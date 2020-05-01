package com.bank.financial.transaction;

import com.bank.financial.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "transactions")
public class TransactionController {

  @Autowired
  private TransactionProducer transactionProducer;

  @PostMapping
  public void addTransaction(@RequestBody Transaction transaction) {
    transactionProducer.sendMessage(transaction);
  }
}
