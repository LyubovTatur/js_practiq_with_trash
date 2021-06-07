package com.company.services;


import com.company.utils.SessionUtil;

import com.company.dao.ActorFilmDAO;
import com.company.package_tables.ActorFilm;
import org.hibernate.Session;

import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;

public class ActorFilmService  extends SessionUtil implements ActorFilmDAO {


    public void add(ActorFilm actorFilm) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(actorFilm);

        //close session with a transaction
        closeTransactionSession();
    }

    public List<ActorFilm> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM Actor_Film";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(ActorFilm.class);
        List<ActorFilm> actorFilmList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return actorFilmList;
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
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(actorFilm);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(ActorFilm actorFilm) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(actorFilm);

        //close session with a transaction
        closeTransactionSession();
    }
}
