package com.pgd.poc.msdistancespringreactive.controller;



import com.pgd.poc.msdistancespringreactive.model.Person;
import com.pgd.poc.msdistancespringreactive.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/person")
@RequiredArgsConstructor
@Log4j2
public class PersonController {


    private final PersonService personService;

    @GetMapping
    public ResponseEntity<Flux<Person>> getAll() {
        return ResponseEntity.ok().body(personService.getAll());
    }

    @PostMapping(value = "/bulk")
    public Mono<ResponseEntity<String>> saveAll(@RequestBody List<Person> persons){
        return personService.bulk(persons).then()
                .map(unused -> ResponseEntity.status(HttpStatus.CREATED.value())
                        .body(HttpStatus.CREATED.getReasonPhrase()))
                .doOnError(throwable -> log.log(Level.ERROR, throwable.getMessage()))
                .onErrorReturn(SQLException.class, ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .body(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()))
                .onErrorReturn(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .body(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
    }
}
