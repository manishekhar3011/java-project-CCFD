package com.learn.frauddetection.dao;

import com.learn.frauddetection.entities.FraudDetectionRecord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class FraudDetectionDao {

    private SessionFactory factory;

    public FraudDetectionDao(SessionFactory factory) {
        this.factory = factory;
    }

    // Get fraud detection record by card number and fraud type
    public FraudDetectionRecord getFraudRecordByCardNumberAndType(String cardNumber, String fraudType) {
        FraudDetectionRecord record = null;

        try {
            String query = "from FraudDetectionRecord where cardNumber =: cn and fraudType =: ft";
            Session session = this.factory.openSession();
            Query q = session.createQuery(query);
            q.setParameter("cn", cardNumber);
            q.setParameter("ft", fraudType);
            record = (FraudDetectionRecord) q.uniqueResult();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return record;
    }
}
