package com.learn.frauddetection.dao;

import com.learn.frauddetection.entities.FraudDetectionRecord;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class FraudDetectionDao {

    private SessionFactory factory;

    public FraudDetectionDao(SessionFactory factory) {
        this.factory = factory;
    }

    // Save a fraud detection record
    public boolean saveFraudRecord(FraudDetectionRecord record) {
        boolean isSaved = false;
        try {
            Session session = this.factory.openSession();
            Transaction tx = session.beginTransaction();

            session.save(record);

            tx.commit();
            session.close();
            isSaved = true;
        } catch (Exception e) {
            e.printStackTrace();
            isSaved = false;
        }
        return isSaved;
    }

    // Get all fraud detection records
    public List<FraudDetectionRecord> getAllFraudRecords() {
        Session session = this.factory.openSession();
        Query query = session.createQuery("from FraudDetectionRecord");
        List<FraudDetectionRecord> list = query.list();
        session.close();
        return list;
    }

    // Get all fraud detection records by card number
    public List<FraudDetectionRecord> getFraudRecordsByCardNumber(String cardNumber) {
        Session session = this.factory.openSession();
        Query query = session.createQuery("from FraudDetectionRecord as f where f.cardNumber =: cn");
        query.setParameter("cn", cardNumber);
        List<FraudDetectionRecord> list = query.list();
        session.close();
        return list;
    }

    // Get all fraud detection records by fraud type
    public List<FraudDetectionRecord> getFraudRecordsByFraudType(String fraudType) {
        Session session = this.factory.openSession();
        Query query = session.createQuery("from FraudDetectionRecord as f where f.fraudType =: ft");
        query.setParameter("ft", fraudType);
        List<FraudDetectionRecord> list = query.list();
        session.close();
        return list;
    }
}
