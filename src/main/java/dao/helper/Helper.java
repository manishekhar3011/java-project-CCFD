package com.learn.frauddetection.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        try {
            // Initialize the SessionFactory if it is not already initialized
            if (factory == null) {
                factory = new Configuration()
                        .configure("hibernate.cfg.xml") // Ensure your hibernate.cfg.xml is set up correctly
                        .addAnnotatedClass(Transaction.class) // Add any relevant classes like Transaction, FraudAlert, etc.
                        .addAnnotatedClass(FraudAlert.class)
                        .buildSessionFactory();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to create SessionFactory. Please check your configuration.");
        }

        return factory;
    }

    public static void closeFactory() {
        // Close the factory if it was created
        if (factory != null) {
            factory.close();
        }
    }
}
