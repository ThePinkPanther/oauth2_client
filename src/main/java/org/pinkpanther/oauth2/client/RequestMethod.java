package org.pinkpanther.oauth2.client;

/**
 * @author ben
 * @version 1.0
 */
public enum RequestMethod {
    GET("GET"),
    POST("POST")
    ;
    private final String value;

    public String getValue() {
        return value;
    }

    RequestMethod(String value) {

        this.value = value;
    }
}
