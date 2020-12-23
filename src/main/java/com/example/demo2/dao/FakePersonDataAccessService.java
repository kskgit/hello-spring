package com.example.demo2.dao;

import com.example.demo2.model.Person;
import com.example.demo2.dao.PersonDao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
  private static final Logger logger = LoggerFactory.getLogger(FakePersonDataAccessService.class);
  private static List<Person> DB = new ArrayList<>();

  @Override
  public int insertPerson(UUID id, Person person) {
    DB.add(new Person(id, person.getName()));
    return 1;
  }

  @Override
  public List<Person> selectAllPeople() {
    return DB;
  }

  @Override
  public Optional<Person> selectPersonById(UUID id) {
    return DB.stream()
      .filter(person -> person.getId().equals(id))
      .findFirst();
  }

  @Override
  public int deletePersonById(UUID id) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int updatePersonById(UUID id) {
    // TODO Auto-generated method stub
    return 0;
  }
}