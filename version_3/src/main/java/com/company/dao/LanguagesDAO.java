package com.company.dao;

import com.company.package_tables.Languages;

import java.sql.SQLException;
import java.util.List;

public interface LanguagesDAO {
    void add(Languages address) throws SQLException;

    //read
    List<Languages> getAll() throws SQLException;

    Languages getById(Long id) throws SQLException;

    //update
    void update(Languages address) throws SQLException;

    //delete
    void remove(Languages address) throws SQLException;
}
