package model.service;

import model.entity.Person;

import java.rmi.Remote;
import java.util.List;

public interface PersonService extends Remote {
    void save(Person person) throws Exception;

    void update(Person person) throws Exception;

    void remove(Person person) throws Exception;

    List<Person> findAll() throws Exception;
}
