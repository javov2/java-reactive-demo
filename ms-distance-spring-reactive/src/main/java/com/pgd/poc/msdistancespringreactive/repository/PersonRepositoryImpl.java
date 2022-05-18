package com.pgd.poc.msdistancespringreactive.repository;

import com.pgd.poc.msdistancespringreactive.model.Location;
import com.pgd.poc.msdistancespringreactive.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.CriteriaDefinition;
import org.springframework.data.relational.core.query.Query;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

import static org.springframework.data.relational.core.query.Criteria.where;

@Repository
@RequiredArgsConstructor
public class PersonRepositoryImpl implements CustomPersonRepository {


    private final R2dbcEntityTemplate template;

    public static final String SELECT_ALL_PERSON = "SELECT person.*," +
            "location.id as loc_id," +
            "location.latitude as loc_lat," +
            "location.longitude as loc_lon," +
            "location.elevation as loc_ele " +
            "FROM person " +
            "JOIN location ON person.location_id = location.id ";

    public static final String INSERT_PERSON_QUERY = "INSERT INTO location (id, latitude, longitude, elevation) " +
            "VALUES ('?loc_id', '?loc_lat', '?loc_lon', '?loc_ele');" +
            "INSERT INTO person (id, first_name, last_name, email, location_id) " +
            "VALUES ('?id', '?first_name', '?last_name', '?email', '?location_id');";

    @Override
    public Flux<Person> findAllPerson() {
        return template.select(Person.class).all()
                .flatMap(this::addLocation);
    }

    private Mono<Person> addLocation(Person person){
        return getLocation(person.getLocation().getId())
                .map(location -> person.toBuilder()
                        .location(location)
                        .build());
    }

    private Mono<Location> getLocation(UUID id){
        return template.selectOne(Query.query(where("id").is(id.toString())),Location.class);
    }

    @Override
    public Flux<Person> bulk(List<Person> people) {
        return null;
    }
}
