package com.example.jdbcDemo.dao;


public interface PersonDao {
    int create(Person person);
    void update(Person person);
    void delete(Person person);
    boolean exist(Person person);
}