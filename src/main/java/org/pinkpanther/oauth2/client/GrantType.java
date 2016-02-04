package org.pinkpanther.oauth2.client;

/**
 * @author ben
 * @version 1.0
 */
public enum GrantType {
    CODE("code"),
    PASSWORD("password"),
    CLIENT("client_credentials"),
    REFRESH("refresh_token")
    ;

    private final String value;

    public String getValue() {
        return value;
    }

    GrantType(String value) {

        this.value = value;
    }

}
