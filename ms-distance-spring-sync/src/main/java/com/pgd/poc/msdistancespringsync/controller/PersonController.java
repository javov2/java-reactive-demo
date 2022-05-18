package com.pgd.poc.msdistancespringsync.controller;

import com.pgd.poc.msdistancespringsync.model.Person;
import com.pgd.poc.msdistancespringsync.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    public List<Person> getAll() {
        return personRepository.findAll();
    }

}
