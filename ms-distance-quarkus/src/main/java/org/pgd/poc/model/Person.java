package org.pgd.poc.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Person {
    UUID id;
    String firstName;
    String lastName;
    String email;
    Location location;

}
