package com.mgb.view.common.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;

/**
 * Created by mgb on 27/03/2016.
 */
//@JsonSerialize(using = DateTimeSerializer.class) TODO: why is not working?
public class DateTimeSerializer extends JsonSerializer<DateTime> {

    DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/YYYY HH:mm:ss");

    @Override
    public void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeString(dtf.print(value));
    }

    @Override
    public Class<DateTime> handledType() {
        return DateTime.class;
    }
}