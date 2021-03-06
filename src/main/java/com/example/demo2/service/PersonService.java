package com.example.demo2.service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo2.dao.PersonDao;
import com.example.demo2.dao.PersonDaoMapper;
import com.example.demo2.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  // private final PersonDao personDao;
  private final PersonDaoMapper personDao;

  @Autowired
  // public PersonService(@Qualifier("postgress") PersonDaoMapper personDao) {
  public PersonService(@Qualifier("mybaitis") PersonDaoMapper personDao) {
    this.personDao = personDao;
  }

  public int addPerson(Person person) {
    UUID id = UUID.randomUUID();
    return personDao.insertPerson(id, person);
  }

  public List<Person> getAllPeople() {
    return personDao.selectAllPeople();
  }

  public Optional<Person> getPersonById(UUID id) {
    return personDao.selectPersonById(id);
  }

  public int deletePersonById(UUID id) {
    return personDao.deletePersonById(id);
  }

  public int updatePerson(UUID id, Person newPerson) {
    return personDao.updatePersonById(id, newPerson);
  }

}
