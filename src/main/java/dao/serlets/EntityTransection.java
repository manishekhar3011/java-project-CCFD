package com.learn.frauddetection.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @Column(length = 50)
    private String cardNumber;

    @Column(length = 200)
    private String merchantName;

    private double transactionAmount;

    @Column(length = 100)
    private String transactionType; // e.g., 'Purchase', 'Refund', etc.

    private String status; // e.g., 'Pending', 'Completed', 'Failed'

    public Transaction() {
    }

    public Transaction(String cardNumber, String merchantName, double transactionAmount, String transactionType, String status) {
        this.cardNumber = cardNumber;
        this.merchantName = merchantName;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
        this.status = status;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
