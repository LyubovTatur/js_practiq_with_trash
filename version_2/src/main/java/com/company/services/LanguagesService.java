package com.company.services;


import com.company.dao.LanguagesDAO;
import com.company.package_tables.Languages;
import com.company.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class LanguagesService extends SessionUtil implements LanguagesDAO {


    public void add(Languages languages) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(languages);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public List<Languages> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM Languages";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Languages.class);
        List<Languages> languagesList = query.list();

        //close session with a transaction
        closeTransactionSesstion();

        return languagesList;
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
        closeTransactionSesstion();

        return languages;
    }

    public void update(Languages languages) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(languages);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public void remove(Languages languages) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(languages);

        //close session with a transaction
        closeTransactionSesstion();
    }
}
