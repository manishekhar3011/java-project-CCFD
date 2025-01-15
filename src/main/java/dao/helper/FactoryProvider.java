package com.learn.frauddetection.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        try {

            if (factory == null) {
                factory = new Configuration()
                        .configure("hibernate.cfg.xml") // Configuration file for Hibernate
                        .buildSessionFactory();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to create SessionFactory. Please check your configuration.");
        }

        return factory;
    }

    public static void closeFactory() {
        if (factory != null) {
            factory.close();
        }
    }
}
