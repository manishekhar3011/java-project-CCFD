package com.learn.frauddetection.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreditCardUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10, name = "user_id")
    private int userId;

    @Column(length = 100, name = "user_name")
    private String userName;

    @Column(length = 100, name = "user_email")
    private String userEmail;

    @Column(length = 20, name = "card_number")
    private String cardNumber;

    @Column(length = 5, name = "card_expiry_date")
    private String cardExpiryDate;

    @Column(length = 4, name = "card_cvv")
    private String cardCVV;

    @Column(length = 15, name = "user_phone")
    private String userPhone;

    @Column(length = 1500, name = "user_address")
    private String userAddress;

    @Column(name = "is_fraudulent")
    private boolean isFraudulent;

    @Column(name = "fraud_score")
    private double fraudScore;

    @Column(name = "user_type")
    private String userType;

    public CreditCardUser(int userId, String userName, String userEmail, String cardNumber, String cardExpiryDate, String cardCVV, String userPhone, String userAddress, boolean isFraudulent, double fraudScore, String userType) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.cardCVV = cardCVV;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.isFraudulent = isFraudulent;
        this.fraudScore = fraudScore;
        this.userType = userType;
    }

    public CreditCardUser(String userName, String userEmail, String cardNumber, String cardExpiryDate, String cardCVV, String userPhone, String userAddress, boolean isFraudulent, double fraudScore, String userType) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.cardCVV = cardCVV;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.isFraudulent = isFraudulent;
        this.fraudScore = fraudScore;
        this.userType = userType;
    }

    public CreditCardUser() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }

    public void setFraudulent(boolean fraudulent) {
        isFraudulent = fraudulent;
    }

    public double getFraudScore() {
        return fraudScore;
    }

    public void setFraudScore(double fraudScore) {
        this.fraudScore = fraudScore;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "CreditCardUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardExpiryDate='" + cardExpiryDate + '\'' +
                ", cardCVV='" + cardCVV + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", isFraudulent=" + isFraudulent +
                ", fraudScore=" + fraudScore +
                ", userType='" + userType + '\'' +
                '}';
    }
}
