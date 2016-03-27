package com.mgb.view.common.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by mgb on 27/03/2016.
 */
public class BigDecimalSerializer extends JsonSerializer<BigDecimal> {

    DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/YYYY HH:mm:ss");

    @Override
    public void serialize(BigDecimal value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeNumber(value.setScale(2, BigDecimal.ROUND_CEILING));
    }

    @Override
    public Class<BigDecimal> handledType() {
        return BigDecimal.class;
    }
}