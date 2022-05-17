package org.pgd.poc.controller;

import io.smallrye.mutiny.Multi;
import org.pgd.poc.model.Person;
import org.pgd.poc.repository.IPersonRepository;
import org.pgd.poc.service.PersonService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonController {

    @Inject
    IPersonRepository personRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<Person> getAllPerson(){
        return personRepository.findAll();
    }

}
