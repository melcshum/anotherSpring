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

/**
 *
 * @author lcshum
 */
public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
    public List<Person> selectAllPerson();

    int deletePersonById(UUID id);
    
    int updatePersonById(UUID id ,  Person person);
    
    
    Optional<Person> selectPersonById(UUID id);
}

