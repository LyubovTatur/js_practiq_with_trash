package com.company.services;


import com.company.dao.DubbingDAO;
import com.company.package_tables.Dubbing;
import com.company.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;
import com.company.utils.HibernateSessionFactoryUtil;

public class DubbingService extends SessionUtil implements DubbingDAO {


    public void add(Dubbing dubbing) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(dubbing);
        tx1.commit();
        session.close();
    }

    public List<Dubbing> getAll() throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        return  (List<Dubbing>) session.getSessionFactory().openSession().createQuery("From Dubbing ").list();

    }

    public Dubbing getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM Dubbing WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Dubbing.class);
        query.setParameter("id", id);

        Dubbing dubbing = (Dubbing) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return dubbing;
    }

    public void update(Dubbing dubbing) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(dubbing);
        tx1.commit();
        session.close();
    }

    public void remove(Dubbing dubbing) throws SQLException {

        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(dubbing);
        tx1.commit();
        session.close();
    }
}
