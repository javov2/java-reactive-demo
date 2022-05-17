package com.pgd.poc.msdistancespringreactive.repository;

import com.pgd.poc.msdistancespringreactive.model.Location;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocationRepository extends R2dbcRepository<Location, UUID> {
}
