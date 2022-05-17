package org.pgd.poc.repository;

import io.smallrye.mutiny.Multi;
import org.pgd.poc.model.Person;

public interface IPersonRepository {

    Multi<Person> findAll();

}
