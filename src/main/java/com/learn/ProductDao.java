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

    // Save a fraud detection record to the database
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

    // Get all fraud detection records for a given card number
    public List<FraudDetectionRecord> getFraudRecordsByCardNumber(String cardNumber) {
        Session session = this.factory.openSession();
        Query query = session.createQuery("from FraudDetectionRecord as r where r.cardNumber =: cardNum");
        query.setParameter("cardNum", cardNumber);
        List<FraudDetectionRecord> list = query.list();
        session.close();
        return list;
    }
}
