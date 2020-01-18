package model.service;

import model.entity.Person;
import model.repository.PersonDA;

import java.util.List;

public class PersonServiceImpl implements PersonService {
    private static PersonServiceImpl personServiceImpl = new PersonServiceImpl();

    private PersonServiceImpl() {
    }

    public static PersonServiceImpl getInstance() {
        return personServiceImpl;
    }

    @Override
    public void save(Person person) throws Exception {
        try (PersonDA personDA = new PersonDA()) {
            personDA.insert(person);
        }
    }

    @Override
    public void update(Person person) throws Exception {
        try (PersonDA personDA = new PersonDA()) {
            personDA.update(person);
        }
    }

    @Override
    public void remove(Person person) throws Exception {
        try (PersonDA personDA = new PersonDA()) {
            personDA.delete(person);
        }
    }

    @Override
    public List<Person> findAll() throws Exception {
        try (PersonDA personDA = new PersonDA()) {
            return personDA.selectAll();
        }
    }
}
