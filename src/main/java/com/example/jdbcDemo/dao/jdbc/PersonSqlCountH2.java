package com.example.jdbcDemo.dao.jdbc;

import java.sql.Types;

import javax.sql.DataSource;

import com.example.jdbcDemo.dao.Person;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlFunction;

public class PersonSqlCountH2 extends SqlFunction<Integer>{
    public PersonSqlCountH2(final DataSource ds){
        setDataSource(ds);
        setSql("select count(*) from Person where id = ?");
        declareParameter(new SqlParameter("id", Types.BIGINT));
        compile();
    }

    public int run(final Person person) {
        return run(person.getId());
    }    
}
