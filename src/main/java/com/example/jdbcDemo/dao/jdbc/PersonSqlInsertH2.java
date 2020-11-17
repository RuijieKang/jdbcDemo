package com.example.jdbcDemo.dao.jdbc;

import java.sql.Types;
import javax.sql.DataSource;

import com.example.jdbcDemo.dao.Person;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class PersonSqlInsertH2 extends SqlUpdate {
    public PersonSqlInsertH2(final DataSource ds) {
        setDataSource(ds);
        setSql("insert into Person(name,age) values(?,?)");
        declareParameter(new SqlParameter(Types.VARCHAR));
        declareParameter(new SqlParameter(Types.INTEGER));
        setReturnGeneratedKeys(true);
        setGeneratedKeysColumnNames(new String[] {"id"});//Assumeing auto-generated column is named "id" 
        compile();
    }

    public int run(final Person person) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Object[] params = new Object[] { person.getName(), person.getAge()};
        update(params, keyHolder);
        return keyHolder.getKey().intValue();//Returning auto-generated column "id"
    }
}
