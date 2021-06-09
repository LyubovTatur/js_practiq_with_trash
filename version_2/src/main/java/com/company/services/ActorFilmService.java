package com.company.services;


import com.company.utils.SessionUtil;

import com.company.dao.ActorFilmDAO;
import com.company.package_tables.ActorFilm;
import org.hibernate.Session;
import com.company.utils.HibernateSessionFactoryUtil;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;

public class ActorFilmService  extends SessionUtil implements ActorFilmDAO {


    public void add(ActorFilm actorFilm) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(actorFilm);
        tx1.commit();
        session.close();
    }

    public List<ActorFilm> getAll() throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        return  (List<ActorFilm>) session.getSessionFactory().openSession().createQuery("From ActorFilm ").list();

    }

    public ActorFilm getById(Long id) throws SQLException {
        //open session with a transaction


       openTransactionSession();

       String sql = "SELECT * FROM Actor_Film WHERE ID = :id";

       Session session = getSession();
       Query query = session.createNativeQuery(sql).addEntity(ActorFilm.class);
       query.setParameter("id", id);

       ActorFilm actorFilm = (ActorFilm) query.getSingleResult();

       //close session with a transaction
       closeTransactionSession();

       return actorFilm;
    }

    public void update(ActorFilm actorFilm) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(actorFilm);
        tx1.commit();
        session.close();
    }

    public void remove(ActorFilm actorFilm) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(actorFilm);
        tx1.commit();
        session.close();
    }
}
