package org.pgd.poc.controller;

import io.smallrye.mutiny.Multi;
import org.pgd.poc.model.Person;
import org.pgd.poc.service.PersonService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonController {

    @Inject
    PersonService personService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<Person> getAllPerson(){
        return Multi.createFrom().item(() -> Person.builder().build());
    }

}
