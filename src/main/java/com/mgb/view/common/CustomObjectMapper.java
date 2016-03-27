package com.mgb.view.common;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mgb.view.common.json.BigDecimalSerializer;
import com.mgb.view.common.json.DateTimeSerializer;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import java.math.BigDecimal;

/**
 * Created by mgb on 27/03/2016.
 */
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        SimpleModule module = new SimpleModule("JSONModule", new Version(2, 0, 0, null, null, null));
        module.addSerializer(DateTime.class, new DateTimeSerializer());
        module.addSerializer(BigDecimal.class, new BigDecimalSerializer());
        registerModule(module);
    }
}
