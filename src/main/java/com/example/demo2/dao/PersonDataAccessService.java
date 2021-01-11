package com.example.demo2.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo2.model.Person;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("postgress")
public class PersonDataAccessService implements PersonDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertPerson(UUID id, Person person) {
    return jdbcTemplate.update(
      "INSERT INTO person (id,name) VALUES(?,?) "
      ,id
      ,person.getName()
    );
  }

  @Override
  public List<Person> selectAllPeople() {
    final String sql = "SELECT id,name FROM person";
    return jdbcTemplate.query(sql, (resultSet, i) -> {
      UUID id = UUID.fromString(resultSet.getString("id"));
      String name = resultSet.getString("name");
      return new Person(id, name);
    });
  }

  @Override
  public Optional<Person> selectPersonById(UUID id) {
    final String sql = "SELECT id,name FROM person WHERE id = ?";
    Person person = jdbcTemplate.queryForObject(
      sql,
      new Object[]{id},
      (resultSet, i) -> {
        UUID personId = UUID.fromString(resultSet.getString("id"));
        String name = resultSet.getString("name");
        return new Person(personId, name);
    });
    return Optional.ofNullable(person);
  }

  @Override
  public int deletePersonById(UUID id) {
    return jdbcTemplate.update(
      "DELETE FROM person WHERE id = ?"
      ,id
    );
  }

  @Override
  public int updatePersonById(UUID id, Person person) {
    return jdbcTemplate.update(
      "UPDATE person SET name = ? WHERE id = ?"
      ,person.getName()
      ,id
    );
  }
}
