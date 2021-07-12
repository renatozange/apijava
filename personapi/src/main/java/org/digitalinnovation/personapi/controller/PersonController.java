package org.digitalinnovation.personapi.controller;

import org.digitalinnovation.personapi.dto.MessageresponseDTO;
import org.digitalinnovation.personapi.entity.Person;
import org.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageresponseDTO createPerson(@RequestBody Person person){
        Person savedPerson = personRepository.save(person);
        return MessageresponseDTO
                .builder()
                .message("Created Person  with ID " + savedPerson.getId())
                .build();
    }
}
