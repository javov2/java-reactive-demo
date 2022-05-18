package com.pgd.poc.msdistancespringsync.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@Entity
public class Location {
    @Id
    @Type(type="uuid-char")
    UUID id;
    String latitude;
    String longitude;
    Integer elevation;
}
