package com.bank.financial.transaction;

import com.bank.financial.entity.Transaction;
import java.util.Date;

public class Payment {

  private Double amount;
  private Date date;
  private String message;
  private Integer id;
  private Transaction transaction;

  public Double getAmount() {
    if (amount == null){
      return 0.0;
    }else {
      return amount;
    }
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public boolean isNegative(){
    return amount < 0;
  }

}
