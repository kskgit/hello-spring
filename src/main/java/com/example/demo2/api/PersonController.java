package com.example.demo2.api;

import java.util.List;
import java.util.UUID;

import com.example.demo2.model.Person;
import com.example.demo2.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

  private final PersonService personService;

  @GetMapping("{id}")
  public Person getPersonById(@PathVariable("id") UUID id) {
    return personService.getPersonById(id)
                        .orElse(null);
  }

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  public void addPerson(@RequestBody Person person) {
    personService.addPerson(person);
  }

  @GetMapping
  public List<Person> getAllPeople() {
    return personService.getAllPeople();
  }

}
