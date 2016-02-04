package org.pinkpanther.oauth2.client;

/**
 * @author ben
 * @version 1.0
 */
public enum ResponseType {
    CODE("code"),
    TOKEN("token")
    ;
    private final String value;

    public String getValue() {
        return value;
    }

    ResponseType(String value) {
        this.value = value;
    }

}
