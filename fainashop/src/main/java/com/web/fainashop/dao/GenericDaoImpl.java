package com.web.fainashop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Home on 27.09.2014.
 */
public class GenericDaoImpl<T> implements GenericDao<T>{

    private Class<T> entity;
    private boolean status;
    SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    public GenericDaoImpl(Class<T> entity){
        this.entity = entity;
    }

    public boolean save(T item){
        status = false;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
            status = true;
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }

        return status;
    }

    public boolean update(T item){
        status = false;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            session.update(item);
            transaction.commit();
            status = true;
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }

        return status;
    }

    public T getById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        T obj = null;

        try {
            transaction = session.beginTransaction();
            obj = (T)session.get(entity, id);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }

        return obj;
    }

    public List<T> getAll(){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<T> objs = new ArrayList<T>();

        try {
            transaction  = session.beginTransaction();
            objs = session.createCriteria(entity).list();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }

        return objs;
    }

    public boolean delete(T item){
        status = false;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            session.delete(item);
            transaction.commit();
            status = true;
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }

        return status;
    }

}
