package model.repository;

import model.common.JDBCProvider;
import model.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonDA() throws Exception {
        connection = JDBCProvider.getConnection();
        connection.setAutoCommit(false);
    }

    public void insert(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("select person_seq.nextval nid from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        person.setId(resultSet.getLong("nid"));
        preparedStatement = connection.prepareStatement("insert into person (id,name,family) values (?,?,?)");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getFamily());
        preparedStatement.executeUpdate();
    }

    public void update(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("update person set name=?, family=? where id=?");
        preparedStatement.setLong(3, person.getId());
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.executeUpdate();
    }

    public void delete(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("delete from person where id=?");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.executeUpdate();
    }

    public List<Person> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Person> personList = new ArrayList<>();
        while (resultSet.next()) {
            Person person = new Person()
                    .setId(resultSet.getLong("id"))
                    .setName(resultSet.getString("name"))
                    .setFamily(resultSet.getString("family"));
            personList.add(person);

        }
        return personList;
    }

    @Override
    public void close() throws Exception {
        connection.commit();
        preparedStatement.close();
        connection.close();

    }
}
