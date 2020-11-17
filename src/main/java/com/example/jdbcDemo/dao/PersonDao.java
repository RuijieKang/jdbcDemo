package com.example.jdbcDemo.dao;


public interface PersonDao {
    int create(Person user);
    void update(Person user);
    void delete(Person user);
    boolean exist(Person user);
}