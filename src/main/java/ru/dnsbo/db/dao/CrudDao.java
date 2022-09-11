package ru.dnsbo.db.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T> {
    T find(Integer id) throws SQLException;
    void save(T model);
    void update(T model);
    void delete(Integer id);

    List<T> findAll() throws SQLException;
}
