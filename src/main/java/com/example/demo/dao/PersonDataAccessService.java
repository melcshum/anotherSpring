/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dao;

import com.example.demo.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lcshum
 */
@Repository("postgres")
public class PersonDataAccessService implements PersonDao {
//

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return jdbcTemplate.update(
                "insert into person (id, name) values(?,?)",
                id, person.getName());
    }

    @Override
    public List<Person> selectAllPerson() {
        final String sql = "SELECT id, name FROM person";

        List<Person> people = null;
        people = jdbcTemplate.query(sql,
                (resultSet, i) -> {
                    UUID id = UUID.fromString(resultSet.getString("id"));

                    String name = resultSet.getString("name");
                    return new Person(id, name);
                });

        return people;

//        Person p = new Person(UUID.randomUUID(), "from db");
//        List<Person> personList = new ArrayList();
//        personList.add(p);
//        return personList;
        //   return null;    
    }
//

    @Override
    public int deletePersonById(UUID id) {
        return jdbcTemplate.update(
                "delete from person where id = ?",    id);
    }
//

    @Override
    public int updatePersonById(UUID id, Person person) {
     
        return jdbcTemplate.update(
                "update person set name = ? where id = ?",
                person.getName(), id);

    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "SELECT id, name FROM person where id =?";
        Person person = null;
        person = jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                (resultSet, i) -> {
                    UUID personId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    return new Person(personId, name);
                });

        return Optional.ofNullable(person);

    }

}
