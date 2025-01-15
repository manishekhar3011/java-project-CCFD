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
    public int saveFraudRecord(FraudDetectionRecord record) {
        Session session = this.factory.openSession();
        Transaction tx = session.beginTransaction();
        int recordId = (int) session.save(record);
        tx.commit();
        session.close();
        return recordId;
    }

    // Retrieve all fraud detection records
    public List<FraudDetectionRecord> getFraudRecords() {
        Session session = this.factory.openSession();
        Query query = session.createQuery("from FraudDetectionRecord");
        List<FraudDetectionRecord> list = query.list();
        session.close();
        return list;
    }

    // Retrieve a fraud detection record by its ID
    public FraudDetectionRecord getFraudRecordById(int recordId) {
        FraudDetectionRecord record = null;
        try {
            Session session = this.factory.openSession();
            record = session.get(FraudDetectionRecord.class, recordId);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return record;
    }
}
