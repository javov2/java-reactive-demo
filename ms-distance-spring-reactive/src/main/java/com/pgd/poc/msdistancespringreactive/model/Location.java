package com.pgd.poc.msdistancespringreactive.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Location {

    UUID id;
    Double latitude;
    Double longitude;
    Double elevation;

}
