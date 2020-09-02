/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dao;

import com.example.demo.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lcshum
 */
@Repository("postgres")
public class PersonDataAccessService implements PersonDao {
//

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;

    }

    @Override
    public List<Person> selectAllPerson() {
        Person p = new Person(UUID.randomUUID(), "from db");
        List<Person> personList = new ArrayList();
        personList.add(p);
        return personList;
        //   return null;    
    }
//

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }
//

    @Override
    public int updatePersonById(UUID id, Person person) {

        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id
    ) {
        return Optional.empty();
    }

}
