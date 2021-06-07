package com.company.services;


import com.company.dao.FilmsDAO;
import com.company.package_tables.Films;
import com.company.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class FilmsService extends SessionUtil implements FilmsDAO {


    public void add(Films films) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(films);

        //close session with a transaction
        closeTransactionSession();
    }

    public List<Films> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM Films";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Films.class);
        List<Films> filmsList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return filmsList;
    }

    public Films getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM Films WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Films.class);
        query.setParameter("id", id);

        Films films = (Films) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return films;
    }

    public void update(Films films) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(films);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(Films films) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(films);

        //close session with a transaction
        closeTransactionSession();
    }
}
