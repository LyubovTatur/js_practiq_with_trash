package com.company.dao;

import com.company.package_tables.ActorFilm;
import java.sql.SQLException;
import java.util.List;

public interface ActorFilmDAO {
    void add(ActorFilm address) throws SQLException;

    //read
    List<ActorFilm> getAll() throws SQLException;

    ActorFilm getById(Long id) throws SQLException;

    //update
    void update(ActorFilm address) throws SQLException;

    //delete
    void remove(ActorFilm address) throws SQLException;
}
