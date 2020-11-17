package com.example.jdbcDemo.dao.jdbc;

import java.sql.Types;
import javax.sql.DataSource;

import com.example.jdbcDemo.dao.Person;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class PersonSqlDeleteOracle extends SqlUpdate{
    public PersonSqlDeleteOracle(final DataSource ds) {
         setDataSource(ds);
         setSql("delete from SBIE.Person where id = ?");
         declareParameter(new SqlParameter(Types.BIGINT));
         compile();
     }

     //return number of updated rows
     public int run(final Person person) {
         Object[] params =
             new Object[] {
                 person.getId()};
         return update(params);
     }
}
