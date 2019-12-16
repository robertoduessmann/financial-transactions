package com.bank.financialtransactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "transactions")
public class TransactionController {

    private final TransactionProducer transactionProducer;

    @Autowired
    TransactionController(TransactionProducer transactionProducer) {
        this.transactionProducer = transactionProducer;
    }

    @PostMapping
    public void newTransaction(@RequestParam("message") String message) {
        transactionProducer.sendMessage(message);
    }
}
