package org.pgd.poc.service;

import lombok.RequiredArgsConstructor;
import org.pgd.poc.repository.IPersonRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class PersonService {

    private final IPersonRepository personRepository;

}
