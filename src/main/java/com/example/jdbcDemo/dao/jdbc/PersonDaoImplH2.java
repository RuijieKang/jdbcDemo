package com.example.jdbcDemo.dao.jdbc;

import javax.sql.DataSource;

import com.example.jdbcDemo.dao.PersonDao;
import com.example.jdbcDemo.dao.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("PersonDaoImplH2")
public class PersonDaoImplH2 implements PersonDao {
    private final PersonSqlInsertH2 personSqlInsert;
    private final PersonSqlUpdateH2 personSqlUpdate;
    private final PersonSqlDeleteH2 personSqlDelete;
    private final PersonSqlCountH2 personSqlCount;

    @Autowired
    PersonDaoImplH2(final @Qualifier("dataSourceH2") DataSource ds) {
        personSqlInsert = new PersonSqlInsertH2(ds);
        personSqlUpdate = new PersonSqlUpdateH2(ds);
        personSqlDelete = new PersonSqlDeleteH2(ds);
        personSqlCount = new PersonSqlCountH2(ds);
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