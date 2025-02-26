package org.testing.constants;

public class ApiUrlConstants {

    private static final String DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE =
            "https://jsonplaceholder.typicode.com";

    private static final String DEFAULT_JSON_RESOURCE_PATH =
            "src/main/resources/json/";

    private ApiUrlConstants() {

    }

    public static String getDefaultApiJsonPlaceholderTypeCode() {
        return DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE;
    }

    public static String getDefaultJsonResourcePath(){
        return DEFAULT_JSON_RESOURCE_PATH;
    }
}

