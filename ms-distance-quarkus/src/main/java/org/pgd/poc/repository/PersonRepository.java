package org.pgd.poc.repository;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import lombok.RequiredArgsConstructor;
import org.pgd.poc.model.Location;
import org.pgd.poc.model.Person;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
@RequiredArgsConstructor
public class PersonRepository implements IPersonRepository{

    private final PgPool client;
    private static final String FIND_ALL_PERSON_QUERY = "SELECT person.*," +
            "location.id as loc_id," +
            "location.latitude as loc_lat," +
            "location.longitude as loc_lon," +
            "location.elevation as loc_ele " +
            "FROM person " +
            "JOIN location ON person.location_id = location.id ";

    @Override
    public Multi<Person> findAll() {
        return client.query(FIND_ALL_PERSON_QUERY).execute()
                .onItem().transformToMulti(set -> Multi.createFrom().iterable(set))
                .onItem().transform(this::rowToPerson);
    }


    private Person rowToPerson(Row row){
        Location location = Location.builder()
                .id(getUUIDFromRow(row, "loc_id"))
                .latitude(row.getString("loc_lat"))
                .longitude(row.getString("loc_lon"))
                .elevation(row.getShort("loc_ele"))
                .build();
        return Person.builder()
                .id(getUUIDFromRow(row, "id"))
                .firstName(row.getString("first_name"))
                .lastName(row.getString("last_name"))
                .email(row.getString("email"))
                .location(location)
                .build();
    }

    private UUID getUUIDFromRow(Row source, String field) {
        String result = source.getString(field);
        return UUID.fromString(result);
    }
}
