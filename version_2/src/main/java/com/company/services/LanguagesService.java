package com.company.services;


import com.company.dao.LanguagesDAO;
import com.company.package_tables.Languages;
import com.company.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
import com.company.utils.HibernateSessionFactoryUtil;import org.hibernate.Transaction;

public class LanguagesService extends SessionUtil implements LanguagesDAO {


    public void add(Languages languages) throws SQLException {

        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(languages);
        tx1.commit();
        session.close();
    }

    public List<Languages> getAll() throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        return  (List<Languages>) session.getSessionFactory().openSession().createQuery("From Languages ").list();

    }

    public Languages getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM Languages WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Languages.class);
        query.setParameter("id", id);

        Languages languages = (Languages) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return languages;
    }

    public void update(Languages languages) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(languages);
        tx1.commit();
        session.close();
    }

    public void remove(Languages languages) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(languages);
        tx1.commit();
        session.close();
    }
}
