package org.pgd.poc.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Location {
    UUID id;
    String latitude;
    String longitude;
    Short elevation;
}
