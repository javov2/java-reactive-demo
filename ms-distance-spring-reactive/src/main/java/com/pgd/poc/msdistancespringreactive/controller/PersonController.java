package com.pgd.poc.msdistancespringreactive.controller;



import com.pgd.poc.msdistancespringreactive.model.Person;
import com.pgd.poc.msdistancespringreactive.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    public Flux<Person> getAll() {
        return personRepository.findAll();
    }

    @GetMapping(value = "/{uuid}")
    public Mono<Person> getOne(@PathVariable String uuid) {
        return personRepository.findById(UUID.fromString(uuid));
    }
}
