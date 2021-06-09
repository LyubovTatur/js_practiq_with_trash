package com.company.dao;

import com.company.package_tables.Dubbing;

import java.sql.SQLException;
import java.util.List;

public interface DubbingDAO {
    void add(Dubbing address) throws SQLException;

    //read
    List<Dubbing> getAll() throws SQLException;

    Dubbing getById(Long id) throws SQLException;

    //update
    void update(Dubbing address) throws SQLException;

    //delete
    void remove(Dubbing address) throws SQLException;
}
