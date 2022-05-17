package com.pgd.poc.msdistancespringreactive.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Person {
    @Id
    UUID id;
    String firstName;
    String lastName;
    String email;
    Location location;

}
