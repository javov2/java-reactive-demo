package com.pgd.poc.msdistancespringsync.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @Type(type="uuid-char")
    UUID id;
    String firstName;
    String lastName;
    String email;

    @OneToOne(fetch = FetchType.EAGER)
    Location location;

}
