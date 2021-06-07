package com.company.services;


import com.company.dao.CommentsDAO;
import com.company.package_tables.Comments;
import com.company.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class CommentsService extends SessionUtil implements CommentsDAO {


    public void add(Comments comments) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(comments);

        //close session with a transaction
        closeTransactionSession();
    }

    public List<Comments> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM Comments";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Comments.class);
        List<Comments> commentsList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return commentsList;
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
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(comments);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(Comments comments) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(comments);

        //close session with a transaction
        closeTransactionSession();
    }
}
