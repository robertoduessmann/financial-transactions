package com.bank.financial.transaction;

import java.util.List;

public class PaymentProcessor {

  public static void process() {
    Payment payment = new Payment();
    Payment payment2 = new Payment();
    Payment payment3 = new Payment();
    List<Payment> payments = List.of(payment, payment2, payment3);

    payment.setAmount(10.0);
    payment2.setAmount(20.0);
    payment3.setAmount(-5.0);

    Double total = 0.0;
    for (int i = 0; i < payments.size(); i++) {
      System.out.println("Is payment negative? " + payments.get(i).isNegative());
      total = total + payments.get(i).getAmount();
    }
    System.out.println("Total is: " + total);

    User user = new User();
    user.setName("Roberto");
    user.setPayments(payments);

    Payment paymentForVanessa = new Payment();
    paymentForVanessa.setAmount(100.00);
    User user2 = new User();
    user2.setName("Vanessa");
    user2.setPayments(List.of(paymentForVanessa));

    Payment paymentFromUser = user.getPayments().get(0);
  }

  public static void main(String[] args) {
    process();
  }

}
