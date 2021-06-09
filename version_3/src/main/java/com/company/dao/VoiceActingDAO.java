package com.company.dao;

import com.company.package_tables.VoiceActing;

import java.sql.SQLException;
import java.util.List;

public interface VoiceActingDAO {
    void add(VoiceActing address) throws SQLException;

    //read
    List<VoiceActing> getAll() throws SQLException;

    VoiceActing getById(Long id) throws SQLException;

    //update
    void update(VoiceActing address) throws SQLException;

    //delete
    void remove(VoiceActing address) throws SQLException;
}
