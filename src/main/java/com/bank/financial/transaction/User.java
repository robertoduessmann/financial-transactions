package com.bank.financial.transaction;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

  private String name;
  private Integer id;
  private List<Payment> payments;

}
