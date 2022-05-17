package com.pgd.poc.msdistancespringreactive.repository;

import com.pgd.poc.msdistancespringreactive.model.Person;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PersonRepository extends R2dbcRepository<Person, UUID> {
    Mono<Person> findById(UUID uuid);
    @Query("SELECT person.*," +
            " location.id as locationId," +
            " location.latitude as latitude," +
            " location.longitude as longitude," +
            "location.elevation as elevation " +
            "FROM Person person " +
            "JOIN Location person_location on person_location.person_id = person.id ")
    Flux<Person> findAll();
}
