package com.pgd.poc.msdistancespringreactive;


import com.pgd.poc.msdistancespringreactive.model.Location;
import com.pgd.poc.msdistancespringreactive.model.Person;
import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.util.UUID;

@ReadingConverter
public class PersonConverter implements Converter<Row, Person> {

    @Override
    public Person convert(Row source) {
        Location location = Location.builder()

                .build();
        return Person.builder()
                .id(source.get("id", UUID.class))
                .build();
    }

}
