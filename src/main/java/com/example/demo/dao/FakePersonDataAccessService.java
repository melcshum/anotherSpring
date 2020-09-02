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
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 0;
    }

    @Override
    public List<Person> selectAllPerson() {
        return DB;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> p = selectPersonById(id);
        if (!p.isPresent()) {
            return 0;
        }

        DB.remove(p.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person update) {

        return selectPersonById(id).map(
                p -> {
                    int indexOfPersontoUpdate = DB.indexOf(p);
                    if (indexOfPersontoUpdate >= 0) {
                        DB.set(indexOfPersontoUpdate, new Person(id, update.getName()));
                        return 1;
                    }
                    return 0;
                }
        ).orElse(0);

    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {

        return DB.stream().filter(person -> person.getId().equals(id))
                .findFirst();
    }
}
