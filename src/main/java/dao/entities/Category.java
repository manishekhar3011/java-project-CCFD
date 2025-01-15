package com.learn.frauddetection.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FraudDetectionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fraudId;
    private String cardNumber;
    private String transactionDetails;
    private String fraudType;
    private String detectionTimestamp;

    @OneToMany(mappedBy = "fraudDetectionRecord")
    private List<FraudAction> actions = new ArrayList<>();

    public FraudDetectionRecord() {
    }

    public FraudDetectionRecord(int fraudId, String cardNumber, String transactionDetails, String fraudType, String detectionTimestamp) {
        this.fraudId = fraudId;
        this.cardNumber = cardNumber;
        this.transactionDetails = transactionDetails;
        this.fraudType = fraudType;
        this.detectionTimestamp = detectionTimestamp;
    }

    public FraudDetectionRecord(String cardNumber, String transactionDetails, String fraudType, String detectionTimestamp, List<FraudAction> actions) {
        this.cardNumber = cardNumber;
        this.transactionDetails = transactionDetails;
        this.fraudType = fraudType;
        this.detectionTimestamp = detectionTimestamp;
        this.actions = actions;
    }

    public int getFraudId() {
        return fraudId;
    }

    public void setFraudId(int fraudId) {
        this.fraudId = fraudId;
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

    public String getFraudType() {
        return fraudType;
    }

    public void setFraudType(String fraudType) {
        this.fraudType = fraudType;
    }

    public String getDetectionTimestamp() {
        return detectionTimestamp;
    }

    public void setDetectionTimestamp(String detectionTimestamp) {
        this.detectionTimestamp = detectionTimestamp;
    }

    public List<FraudAction> getActions() {
        return actions;
    }

    public void setActions(List<FraudAction> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "FraudDetectionRecord{" +
                "fraudId=" + fraudId +
                ", cardNumber='" + cardNumber + '\'' +
                ", transactionDetails='" + transactionDetails + '\'' +
                ", fraudType='" + fraudType + '\'' +
                ", detectionTimestamp='" + detectionTimestamp + '\'' +
                '}';
    }
}
