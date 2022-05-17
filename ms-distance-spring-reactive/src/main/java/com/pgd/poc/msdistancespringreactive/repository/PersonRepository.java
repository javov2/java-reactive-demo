package com.pgd.poc.msdistancespringreactive.repository;

import com.pgd.poc.msdistancespringreactive.model.Person;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface PersonRepository extends R2dbcRepository<Person, UUID> {
    @Query("SELECT person.*," +
            "location.id as loc_id," +
            "location.latitude as loc_lat," +
            "location.longitude as loc_lon," +
            "location.elevation as loc_ele " +
            "FROM person " +
            "JOIN location ON person.location_id = location.id ")
    Flux<Person> findAll();
}
