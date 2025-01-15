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
        int recordId = 0;
        try (Session session = this.factory.openSession()) {
            Transaction tx = session.beginTransaction();
            recordId = (int) session.save(record);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recordId;
    }

    // Retrieve all fraud detection records
    public List<FraudDetectionRecord> getAllFraudRecords() {
        List<FraudDetectionRecord> list = null;
        try (Session session = this.factory.openSession()) {
            Query<FraudDetectionRecord> query = session.createQuery("from FraudDetectionRecord", FraudDetectionRecord.class);
            list = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Retrieve a specific fraud detection record by ID
    public FraudDetectionRecord getFraudRecordById(int id) {
        FraudDetectionRecord record = null;
        try (Session session = this.factory.openSession()) {
            record = session.get(FraudDetectionRecord.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return record;
    }
}
