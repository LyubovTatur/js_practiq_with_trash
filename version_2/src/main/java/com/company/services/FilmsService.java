package com.company.services;


import com.company.dao.FilmsDAO;
import com.company.package_tables.Actors;
import com.company.package_tables.Films;
import com.company.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
import com.company.utils.HibernateSessionFactoryUtil;
import org.hibernate.Transaction;
public class FilmsService extends SessionUtil implements FilmsDAO {


    public void add(Films films) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(films);
        tx1.commit();
        session.close();
    }

    public List<Films> getAll() throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        return  (List<Films>) session.getSessionFactory().openSession().createQuery("From Films ").list();

    }

    public Films getById(Long id) throws SQLException {
        //open session with a transaction
        Films films = new Films();
        List<Films> all = getAll();
        for (Films f: all) {
            System.out.println(f.getId() + "/"+id);
            if (f.getId() == id)
                films= f;
        }

        return films;
    }

    public void update(Films films) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(films);
        tx1.commit();
        session.close();
    }

    public void remove(Films films) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(films);
        tx1.commit();
        session.close();
    }
}
