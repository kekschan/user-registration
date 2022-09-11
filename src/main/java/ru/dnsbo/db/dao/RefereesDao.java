package ru.dnsbo.db.dao;

import ru.dnsbo.db.referees.Referees;

import java.util.List;

public interface RefereesDao extends CrudDao<Referees> {
    List<Referees> findBySecondNameAndName(String secondName,String name);

}
