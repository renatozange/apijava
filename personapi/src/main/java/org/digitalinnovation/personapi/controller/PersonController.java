package org.digitalinnovation.personapi.controller;

import org.digitalinnovation.personapi.dto.MessageresponseDTO;
import org.digitalinnovation.personapi.entity.Person;
import org.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageresponseDTO createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
}
