package com.company.services;


import com.company.dao.ActorsDAO;
import com.company.package_tables.Actors;
import com.company.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ActorsService extends SessionUtil implements ActorsDAO {


    public void add(Actors actors) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(actors);

        //close session with a transaction
        closeTransactionSession();
    }

    public List<Actors> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM Actors";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Actors.class);
        List<Actors> actorsList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return actorsList;
    }

    public Actors getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM Actors WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Actors.class);
        query.setParameter("id", id);

        Actors actors = (Actors) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return actors;
    }

    public void update(Actors actors) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(actors);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(Actors actors) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(actors);

        //close session with a transaction
        closeTransactionSession();
    }

}
