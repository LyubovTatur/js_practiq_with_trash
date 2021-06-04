package com.company.services;


import com.company.dao.DubbingDAO;
import com.company.package_tables.Dubbing;
import com.company.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class DubbingService extends SessionUtil implements DubbingDAO {


    public void add(Dubbing dubbing) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(dubbing);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public List<Dubbing> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM Dubbing";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Dubbing.class);
        List<Dubbing> dubbingList = query.list();

        //close session with a transaction
        closeTransactionSesstion();

        return dubbingList;
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
        closeTransactionSesstion();

        return dubbing;
    }

    public void update(Dubbing dubbing) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(dubbing);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public void remove(Dubbing dubbing) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(dubbing);

        //close session with a transaction
        closeTransactionSesstion();
    }
}
