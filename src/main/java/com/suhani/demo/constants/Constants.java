package com.suhani.demo.constants;

import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.regex.Pattern;

@UtilityClass
public class Constants {
    public static final Set<String> excludeRequestLogging = Set.of("/actuator", "/api-docs", "/swagger-ui");

    public static final String[] requestLoggingPatterns = new String[]{
            "/v1/*",
            "/v2/*",
            "/api/v1/*",
            "/api/v2/*",
            "/private/*",
            "/internal/*"
    };


}
