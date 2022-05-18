package com.pgd.poc.msdistancespringreactive.repository.converters;


import com.pgd.poc.msdistancespringreactive.model.Location;
import com.pgd.poc.msdistancespringreactive.model.Person;
import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.data.r2dbc.mapping.SettableValue;
import org.springframework.r2dbc.core.Parameter;

import java.util.UUID;

@WritingConverter
public class PersonWriteConverter implements Converter<Person, OutboundRow> {

    @Override
    public OutboundRow convert(Person source) {
        OutboundRow row = new OutboundRow();
        row.put("id", Parameter.from(source.getId().toString()));
        row.put("first_name", Parameter.from(source.getFirstName()));
        row.put("last_name", Parameter.from(source.getLastName()));
        row.put("email", Parameter.from(source.getEmail()));
        row.put("location_id", Parameter.from(source.getLocation().getId()));
        row.put("loc_id", Parameter.from(source.getLocation().getId()));
        row.put("loc_lat", Parameter.from(source.getLocation().getLatitude()));
        row.put("loc_lon", Parameter.from(source.getLocation().getLongitude()));
        row.put("loc_ele", Parameter.from(source.getLocation().getElevation()));
        return row;
    }
}
