package com.bank.financial.transaction;

import org.springframework.beans.factory.annotation.Autowired;

public class Entrypoint {

  @Autowired
  private PaymentProcessor paymentProcessor;

  public void main(String[] args) {
    paymentProcessor.process();
  }

}
