package com.web.fainashop;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: Home
 * Date: 29.08.14
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try {
            return new AnnotationConfiguration().configure().buildSessionFactory();
        }catch (Exception e){
            System.out.println("Initial SessionFactory creation failed "+ e);
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutdown(){
        getSessionFactory().close();
    }
}
