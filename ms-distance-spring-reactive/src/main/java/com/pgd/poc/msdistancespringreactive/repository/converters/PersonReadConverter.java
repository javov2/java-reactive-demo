package com.pgd.poc.msdistancespringreactive.repository.converters;


import com.pgd.poc.msdistancespringreactive.model.Location;
import com.pgd.poc.msdistancespringreactive.model.Person;
import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.util.UUID;

@ReadingConverter
public class PersonReadConverter implements Converter<Row, Person> {

    @Override
    public Person convert(Row source) {
        Location location = Location.builder()
                .id(getUUIDFromRow(source, "loc_id"))
                .latitude(source.get("loc_lat", String.class))
                .longitude(source.get("loc_lon", String.class))
                .elevation(source.get("loc_ele", Short.class))
                .build();
        return Person.builder()
                .id(getUUIDFromRow(source, "id"))
                .firstName(source.get("first_name", String.class))
                .lastName(source.get("last_name", String.class))
                .email(source.get("email", String.class))
                .location(location)
                .build();
    }

    private UUID getUUIDFromRow(Row source, String field) {
        String result = source.get(field, String.class);
        return UUID.fromString(result);
    }

}
