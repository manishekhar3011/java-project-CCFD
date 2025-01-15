package com.learn.frauddetection.dao;

import com.learn.frauddetection.entities.FraudAlert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FraudAlertDao {

    private SessionFactory factory;

    public FraudAlertDao(SessionFactory factory) {
        this.factory = factory;
    }

    // Save fraud alert
    public boolean saveFraudAlert(FraudAlert fraudAlert) {
        boolean success = false;
        try {
            Session session = this.factory.openSession();
            session.beginTransaction();
            session.save(fraudAlert);
            session.getTransaction().commit();
            session.close();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    // Get fraud alerts for a card
    public FraudAlert getFraudAlertByCardNumber(String cardNumber) {
        Session session = this.factory.openSession();
        Query query = session.createQuery("from FraudAlert where cardNumber = :cardNumber");
        query.setParameter("cardNumber", cardNumber);
        FraudAlert fraudAlert = (FraudAlert) query.uniqueResult();
        session.close();
        return fraudAlert;
    }
}
