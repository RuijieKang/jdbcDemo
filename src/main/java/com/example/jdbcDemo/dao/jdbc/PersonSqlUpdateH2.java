package com.example.jdbcDemo.dao.jdbc;

import java.sql.Types;
import javax.sql.DataSource;

import com.example.jdbcDemo.dao.Person;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class PersonSqlUpdateH2 extends SqlUpdate {
    public PersonSqlUpdateH2(final DataSource ds) {
        setDataSource(ds);
        setSql("update Person set name = ?, age = ? where id = ?");
        declareParameter(new SqlParameter(Types.VARCHAR));
        declareParameter(new SqlParameter(Types.INTEGER));
        declareParameter(new SqlParameter(Types.BIGINT));
        compile();
    }

    public int run(final Person person) {
        Object[] params =
            new Object[] {
                person.getName(),
                person.getAge(),
                person.getId()};
        return update(params);
    }
}