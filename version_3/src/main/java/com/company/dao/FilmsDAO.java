package com.company.dao;

import com.company.package_tables.Films;

import java.sql.SQLException;
import java.util.List;

public interface FilmsDAO {
    void add(Films address) throws SQLException;

    //read
    List<Films> getAll() throws SQLException;

    Films getById(Long id) throws SQLException;

    //update
    void update(Films address) throws SQLException;

    //delete
    void remove(Films address) throws SQLException;
}
