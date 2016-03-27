package com.mgb.view.common;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mgb.view.common.json.DateTimeSerializer;

/**
 * Created by mgb on 27/03/2016.
 */
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule testModule = new SimpleModule("MyModule", new Version(1, 0, 0, null));
        testModule.addSerializer(new DateTimeSerializer());
        mapper.registerModule(testModule);
    }
}
