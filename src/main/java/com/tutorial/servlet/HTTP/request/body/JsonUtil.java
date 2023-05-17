package com.tutorial.servlet.HTTP.request.body;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    /**
     * class helper
     */

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static ObjectMapper getObjectMapper(){
        return OBJECT_MAPPER;
    }

}
