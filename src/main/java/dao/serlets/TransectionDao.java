package com.learn.frauddetection.dao;

import com.learn.frauddetection.entities.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class TransactionDao {

    private SessionFactory factory;

    public TransactionDao(SessionFactory factory) {
        this.factory = factory;
    }

    // Save a transaction
    public boolean saveTransaction(Transaction transaction) {
        boolean success = false;
        try {
            Session session = this.factory.openSession();
            session.beginTransaction();
            session.save(transaction);
            session.getTransaction().commit();
            session.close();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    // Get all transactions
    public List<Transaction> getAllTransactions() {
        Session session = this.factory.openSession();
        Query query = session.createQuery("from Transaction");
        List<Transaction> transactions = query.list();
        session.close();
        return transactions;
    }

    // Find suspicious transactions (e.g., high amount, same merchant)
    public List<Transaction> getSuspiciousTransactions() {
        Session session = this.factory.openSession();
        Query query = session.createQuery("from Transaction where transactionAmount > :amount");
        query.setParameter("amount", 1000); // Example threshold
        List<Transaction> suspiciousTransactions = query.list();
        session.close();
        return suspiciousTransactions;
    }
}
