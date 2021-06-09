package com.company.dao;

import com.company.package_tables.Actors;

import java.sql.SQLException;
import java.util.List;

public interface ActorsDAO {
    void add(Actors address) throws SQLException;

    //read
    List<Actors> getAll() throws SQLException;

    Actors getById(Long id) throws SQLException;

    //update
    void update(Actors address) throws SQLException;

    //delete
    void remove(Actors address) throws SQLException;
}
