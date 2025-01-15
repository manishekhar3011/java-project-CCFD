package com.learn.frauddetection.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FraudTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    private String cardNumber;

    @Column(length = 3000)
    private String transactionDetails;

    private String transactionLocation;

    private double transactionAmount;

    private boolean isFraudulent;

    private double fraudRiskScore; // Risk score indicating likelihood of fraud

    @ManyToOne
    private FraudDetectionRecord fraudDetectionRecord;

    public FraudTransaction() {
    }

    public FraudTransaction(String cardNumber, String transactionDetails, String transactionLocation, double transactionAmount, boolean isFraudulent, double fraudRiskScore, FraudDetectionRecord fraudDetectionRecord) {
        this.cardNumber = cardNumber;
        this.transactionDetails = transactionDetails;
        this.transactionLocation = transactionLocation;
        this.transactionAmount = transactionAmount;
        this.isFraudulent = isFraudulent;
        this.fraudRiskScore = fraudRiskScore;
        this.fraudDetectionRecord = fraudDetectionRecord;
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

    public String getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(String transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public String getTransactionLocation() {
        return transactionLocation;
    }

    public void setTransactionLocation(String transactionLocation) {
        this.transactionLocation = transactionLocation;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }

    public void setFraudulent(boolean fraudulent) {
        isFraudulent = fraudulent;
    }

    public double getFraudRiskScore() {
        return fraudRiskScore;
    }

    public void setFraudRiskScore(double fraudRiskScore) {
        this.fraudRiskScore = fraudRiskScore;
    }

    public FraudDetectionRecord getFraudDetectionRecord() {
        return fraudDetectionRecord;
    }

    public void setFraudDetectionRecord(FraudDetectionRecord fraudDetectionRecord) {
        this.fraudDetectionRecord = fraudDetectionRecord;
    }

    @Override
    public String toString() {
        return "FraudTransaction{" +
                "transactionId=" + transactionId +
                ", cardNumber='" + cardNumber + '\'' +
                ", transactionDetails='" + transactionDetails + '\'' +
                ", transactionLocation='" + transactionLocation + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", isFraudulent=" + isFraudulent +
                ", fraudRiskScore=" + fraudRiskScore +
                '}';
    }

    // Calculate risk score based on amount and location
    public double calculateRiskScore() {
        double baseRisk = transactionAmount > 1000 ? 50 : 10;
        if ("high-risk-location".equalsIgnoreCase(transactionLocation)) {
            baseRisk += 30;
        }
        return baseRisk + (isFraudulent ? 20 : 0);
    }
}
