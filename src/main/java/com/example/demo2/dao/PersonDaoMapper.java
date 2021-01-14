package com.example.demo2.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.example.demo2.model.Person;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("mybaitis")
public interface PersonDaoMapper {
  public int insertPerson(@Param("personId") UUID id, @Param("personName") Person person);

  // public default int insertPerson(Person person) {
  //   System.out.println("DAO到達");
  //   UUID id = UUID.randomUUID();
  //   return insert(id, person);
  // }

  public Optional<Person> selectPersonById(UUID id);

  public int deletePersonById(UUID id);

  public int updatePersonById(UUID id, Person person);

  public List<Person> selectAllPeople();

}
