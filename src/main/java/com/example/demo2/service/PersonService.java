package com.example.demo2.service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo2.dao.PersonDao;
import com.example.demo2.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private final PersonDao personDao;

  @Autowired
  public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
    this.personDao = personDao;
  }

  public int addPerson(Person person) {
    return personDao.insertPerson(person);
  }

  public List<Person> getAllPeople() {
    return personDao.selectAllPeople();
  }

  public Optional<Person> getPersonById(UUID id) {
    return personDao.selectPersonById(id);
  }
}
