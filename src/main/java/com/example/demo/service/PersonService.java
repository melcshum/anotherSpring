/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcshum
 */
@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int insertPerson(Person person) {
        return this.personDao.insertPerson(person);
    }

    public List<Person> getAllPerson() {
        return this.personDao.selectAllPerson();
    }

    public int deletePersonById(UUID id) {
        return this.personDao.deletePersonById(id);
    }

    public int updatePersonById(UUID id, Person p) {
        return this.personDao.updatePersonById(id, p);
    }

    public Optional<Person> getPersonById(UUID id) {
        return this.personDao.selectPersonById(id);
    }

}
