package com.pgd.poc.msdistancespringsync.repository;

import com.pgd.poc.msdistancespringsync.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PersonRepository extends CrudRepository<Person, UUID> {

    List<Person> findAll();

}
