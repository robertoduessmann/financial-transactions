package com.bank.financial.transaction;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class User {

  private String name;
  private Integer id;
  private List<Payment> payments;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
}
