package model.service;

import model.entity.Person;

import java.util.List;

public interface PersonService {
    void save(Person person) throws Exception;

    void update(Person person) throws Exception;

    void remove(Person person) throws Exception;

    List<Person> findAll() throws Exception;
}
