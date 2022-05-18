package com.pgd.poc.msdistancespringreactive.service;

import com.pgd.poc.msdistancespringreactive.model.Person;
import com.pgd.poc.msdistancespringreactive.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Flux<Person> getAll() {
        return personRepository.findAll();
    }

    @Transactional
    public Flux<Person> bulk(List<Person> people) {
        return fillFields(people)
                .flatMap(personRepository::save);

    }

    private Flux<Person> fillFields(List<Person> people) {
        return Flux.fromIterable(people)
                .map(this::addPersonId)
                .map(this::addPersonLocationId);
    }

    private Person addPersonId(Person person) {
        return person.getId() == null
                ? person.toBuilder().id(UUID.randomUUID()).build()
                : person;
    }

    private Person addPersonLocationId(Person person) {
        return person.getLocation().getId() == null
                ? person.toBuilder().location(
                        person.getLocation().toBuilder()
                                .id(UUID.randomUUID())
                                .build())
                .build()
                : person;
    }

}
