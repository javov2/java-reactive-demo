package com.pgd.poc.msdistancespringreactive.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
@Table
public class Location {

    UUID id;
    String latitude;
    String longitude;
    Short elevation;

}
