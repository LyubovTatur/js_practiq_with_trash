package com.company.services;


import com.company.dao.CommentsDAO;
import com.company.package_tables.Comments;
import com.company.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
import com.company.utils.HibernateSessionFactoryUtil;

public class CommentsService extends SessionUtil implements CommentsDAO {


    public void add(Comments comments) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(comments);
        tx1.commit();
        session.close();
    }

    public List<Comments> getAll() throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        return  (List<Comments>) session.getSessionFactory().openSession().createQuery("From Comments ").list();

    }

    public Comments getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM Comments WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Comments.class);
        query.setParameter("id", id);

        Comments comments = (Comments) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return comments;
    }

    public void update(Comments comments) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(comments);
        tx1.commit();
        session.close();
    }

    public void remove(Comments comments) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(comments);
        tx1.commit();
        session.close();
    }
}
