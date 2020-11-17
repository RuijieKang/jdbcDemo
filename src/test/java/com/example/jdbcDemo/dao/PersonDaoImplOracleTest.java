package com.example.jdbcDemo.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

@SpringBootTest
public class PersonDaoImplOracleTest {
    @Autowired
    @Qualifier("PersonDaoImplOracle")
    PersonDao personDao;
    
    @Test
    @Sql(scripts = {"file:src/test/java/com/example/jdbcDemo/resources/data-test-crud-oracle.sql"}, config = @SqlConfig(dataSource = "dataSourceOracle"))
    public void testInsert(){
        Person jack = new Person();
        jack.setName("jack");
        jack.setAge(41);
        int id = personDao.create(jack); 
        Assertions.assertEquals(3, id);
        
        Person jackNew = new Person();
        jackNew.setId(id);
        jackNew.setName("jack");
        jackNew.setAge(41);
        Assertions.assertTrue(personDao.exist(jackNew));
    }

    @Test
    @Sql(scripts = {"file:src/test/java/com/example/jdbcDemo/resources/data-test-crud-oracle.sql"}, config = @SqlConfig(dataSource = "dataSourceOracle"))
    public void testDelete(){        
        Person anna = new Person();
        anna.setId(1);
        anna.setName("anna");
        anna.setAge(5);
        Assertions.assertTrue(personDao.exist(anna));
        personDao.delete(anna);
        Assertions.assertFalse(personDao.exist(anna));
        
        Person brian = new Person();
        brian.setId(2);
        brian.setName("brian");
        brian.setAge(10);
        Assertions.assertTrue(personDao.exist(brian));
        personDao.delete(brian);
        Assertions.assertFalse(personDao.exist(brian)); 
    }

    @Test
    @Sql(scripts = {"file:src/test/java/com/example/jdbcDemo/resources/data-test-crud-oracle.sql"}, config = @SqlConfig(dataSource = "dataSourceOracle"))
    public void testDeleteNotExisted(){        
        Person tom = new Person();
        tom.setId(10);
        tom.setName("tom");
        tom.setAge(9);
        Assertions.assertFalse(personDao.exist(tom));
        personDao.delete(tom);
        Assertions.assertFalse(personDao.exist(tom)); 
    }
    
}
