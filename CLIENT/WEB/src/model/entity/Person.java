package model.entity;

import java.io.Serializable;

//SQL> create sequence person_seq start with 1 increment by 1;
//SQL> create table person (id number, name varchar2(20), family varchar2(20));
public class Person implements Serializable {
    private String name, family;
    private long id;

    public Person() {
    }

    public Person(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public Person(long id, String name, String family) {
        this.name = name;
        this.family = family;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }

    public long getId() {
        return id;
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }
}
