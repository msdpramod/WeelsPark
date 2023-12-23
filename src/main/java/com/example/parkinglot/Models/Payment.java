package com.example.parkinglot.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter @Setter
public class Payment extends BaseModel{
    private int amount;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private String transactionId;
    private String referenceId;
    private Bill bill;
    private Date timeOfPayment;

}
