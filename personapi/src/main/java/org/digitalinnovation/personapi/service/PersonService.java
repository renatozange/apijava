package org.digitalinnovation.personapi.service;

import org.digitalinnovation.personapi.dto.MessageresponseDTO;
import org.digitalinnovation.personapi.entity.Person;
import org.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageresponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageresponseDTO
                .builder()
                .message("Created Person  with ID " + savedPerson.getId())
                .build();
    }
}
