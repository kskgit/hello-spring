package com.example.demo2.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo2.model.Person;

import org.springframework.stereotype.Repository;

@Repository("postgress")
public class PersonDataAccessService implements PersonDao {

  @Override
  public int insertPerson(UUID id, Person person) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<Person> selectAllPeople() {
    return List.of(new Person(UUID.randomUUID(), "FROM POSTGRESS DB"));
  }

  @Override
  public Optional<Person> selectPersonById(UUID id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int deletePersonById(UUID id) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int updatePersonById(UUID id, Person person) {
    // TODO Auto-generated method stub
    return 0;
  }
}