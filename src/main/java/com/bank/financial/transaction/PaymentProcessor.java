package com.bank.financial.transaction;

import java.util.ArrayList;
import java.util.List;

public class PaymentProcessor {

	public static void process() {
		Payment payment = new Payment();
		payment.setAmount(10.0);
		Payment payment2 = new Payment();
		payment2.setAmount(20.0);
		Payment payment3 = new Payment();
		payment3.setAmount(5.0);
		Payment payment4 = new Payment();
		payment3.setAmount(10.0);

		User user = new User();
		user.setName("Roberto");
		List<Payment> listofRobertoPaym = List.of(payment, payment2);
		user.setPayments(listofRobertoPaym);

		User user2 = new User();
		user2.setName("Vanessa");
		user2.setPayments(List.of(payment3, payment4));

		List<User> users = new ArrayList<>();
		users.add(user);
		users.add(user2);

		findUserWithBiggestTransaction(users);

	}

	private static void findUserWithBiggestTransaction(List<User> users) {
		String userWithBiggestTransaction = "";
		double biggestTransaction = 0.0;

		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			for (int j = 0; j < user.getPayments().size(); j++) {
				Payment payment = user.getPayments().get(j);
				System.out.println(user.getName() + ":" + payment.getAmount());
				if(payment.getAmount() > biggestTransaction){
					userWithBiggestTransaction = user.getName();
					biggestTransaction = payment.getAmount();
				}
			}
		}
		System.out.println("The person is: " + userWithBiggestTransaction);
	}

	public static void main(String[] args) {
		process();
	}

}
