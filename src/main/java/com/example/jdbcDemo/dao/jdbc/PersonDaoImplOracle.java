package com.example.jdbcDemo.dao.jdbc;

import javax.sql.DataSource;

import com.example.jdbcDemo.dao.PersonDao;
import com.example.jdbcDemo.dao.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("PersonDaoImplOracle")
public class PersonDaoImplOracle implements PersonDao {
    private final PersonSqlInsertOracle personSqlInsert;
    private final PersonSqlUpdateOracle personSqlUpdate;
    private final PersonSqlDeleteOracle personSqlDelete;
    private final PersonSqlCountOracle personSqlCount;

    @Autowired
    PersonDaoImplOracle(final @Qualifier("dataSourceOracle") DataSource ds) {
        personSqlInsert = new PersonSqlInsertOracle(ds);
        personSqlUpdate = new PersonSqlUpdateOracle(ds);
        personSqlDelete = new PersonSqlDeleteOracle(ds);
        personSqlCount = new PersonSqlCountOracle(ds);
    }

    @Override
    public int create(Person person) {
        return personSqlInsert.run(person);
    }

    @Override
    public void update(Person person) {
        personSqlUpdate.run(person);

    }

    @Override
    public void delete(Person person) {
        personSqlDelete.run(person);
    }

    @Override
    public boolean exist(Person person) {
        return personSqlCount.run(person) != 0;
    }
}