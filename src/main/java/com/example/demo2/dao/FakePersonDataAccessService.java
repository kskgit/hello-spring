package com.example.demo2.dao;

import com.example.demo2.model.Person;
import com.example.demo2.dao.PersonDao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

  private static List<Person> DB = new ArrayList<>();

  @Override
  public int insertPerson(UUID id, Person person) {
    // Logger.debug("FakeDao");
    DB.add(new Person(id, person.getName()));
    return 1;
  }

  @Override
  public List<Person> selectAllPeople() {
    return DB;
  }
}