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

@ApplicationScoped
@RequiredArgsConstructor
public class PersonRepository implements IPersonRepository{

    private final PgPool client;

    @Override
    public Multi<Person> findAll() {

        Uni<RowSet<Row>> rowSet = client.query("SELECT * FROM persons").execute();

        return rowSet
                .onItem().transformToMulti(set -> Multi.createFrom().iterable(set))
                .onItem().transform(this::rowToPerson);
    }


    private Person rowToPerson(Row row){
        return Person.builder()
                .id(row.getUUID("id"))
                .firstName(row.getString("first_name"))
                .lastName(row.getString("last_name"))
                .email(row.getString("email"))
                .location(row.get(Location.class, "location_id"))
                .build();
    }

}
