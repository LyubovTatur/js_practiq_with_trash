package com.company.services;


import com.company.dao.ActorsDAO;
import com.company.package_tables.ActorFilm;
import com.company.package_tables.Actors;
import com.company.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.company.utils.HibernateSessionFactoryUtil;

import java.sql.SQLException;
import java.util.List;

public class ActorsService extends SessionUtil implements ActorsDAO {


    public void add(Actors actors) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(actors);
        tx1.commit();
        session.close();
    }

    public List<Actors> getAll() throws SQLException {
        //open session with a transaction
        Session session = HibernateSessionFactoryUtil.getSession();
        return  (List<Actors>) session.getSessionFactory().openSession().createQuery("From Actors ").list();

    }

    public Actors getById(Long id) throws SQLException {
        //open session with a transaction
        Actors actors = new Actors();
        List<Actors> all = getAll();
        for (Actors a: all) {
            System.out.println(a.getId() + "/"+id);
            if (a.getId() == id)
                actors= a;
        }

        return actors;
    }

    public void update(Actors actors) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(actors);
        tx1.commit();
        session.close();
    }

    public void remove(Actors actors) throws SQLException {
        //open session with a transaction
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(actors);
        tx1.commit();
        session.close();
    }

}
