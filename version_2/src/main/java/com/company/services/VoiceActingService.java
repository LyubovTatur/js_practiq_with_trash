package com.company.services;


import com.company.dao.VoiceActingDAO;
import com.company.package_tables.VoiceActing;
import com.company.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class VoiceActingService extends SessionUtil implements VoiceActingDAO {


    public void add(VoiceActing voiceActing) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(voiceActing);

        //close session with a transaction
        closeTransactionSession();
    }

    public List<VoiceActing> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM Voice_Acting";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(VoiceActing.class);
        List<VoiceActing> voiceActingList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return voiceActingList;
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
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(voiceActing);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(VoiceActing voiceActing) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(voiceActing);

        //close session with a transaction
        closeTransactionSession();
    }
}
