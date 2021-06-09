package com.company.services;


import com.company.dao.VoiceActingDAO;
import com.company.package_tables.VoiceActing;
import com.company.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
import com.company.utils.HibernateSessionFactoryUtil;import org.hibernate.Transaction;

public class VoiceActingService extends SessionUtil implements VoiceActingDAO {


    public void add(VoiceActing voiceActing) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(voiceActing);
        tx1.commit();
        session.close();
    }

    public List<VoiceActing> getAll() throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        return  (List<VoiceActing>) session.getSessionFactory().openSession().createQuery("From VoiceActing ").list();

    }

    public VoiceActing getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM Voice_Acting WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(VoiceActing.class);
        query.setParameter("id", id);

        VoiceActing voiceActing = (VoiceActing) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return voiceActing;
    }

    public void update(VoiceActing voiceActing) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(voiceActing);
        tx1.commit();
        session.close();
    }

    public void remove(VoiceActing voiceActing) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(voiceActing);
        tx1.commit();
        session.close();
    }
}
