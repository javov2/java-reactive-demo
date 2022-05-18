package com.pgd.poc.msdistancespringreactive.repository;

import com.pgd.poc.msdistancespringreactive.model.Person;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CustomPersonRepository{
    Flux<Person> findAllPerson ();
    Flux<Person> bulk (List<Person> people);
}
