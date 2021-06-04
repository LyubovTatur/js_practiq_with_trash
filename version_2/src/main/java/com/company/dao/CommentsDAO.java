package com.company.dao;

import com.company.package_tables.Comments;

import java.sql.SQLException;
import java.util.List;

public interface CommentsDAO {
    void add(Comments address) throws SQLException;

    //read
    List<Comments> getAll() throws SQLException;

    Comments getById(Long id) throws SQLException;

    //update
    void update(Comments address) throws SQLException;

    //delete
    void remove(Comments address) throws SQLException;
}
