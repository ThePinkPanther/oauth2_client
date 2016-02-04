package org.pinkpanther.oauth2.client;

/**
 * @author ben
 * @version 1.0
 */
public enum ErrorType {

    INVALID_REQUEST("invalid_request"),
    INVALID_CLIENT("invalid_client"),
    INVALID_GRANT("invalid_grant"),
    UNAUTHORISED_CLIENT("unauthorized_client"),
    UNSUPPORTED_GRANT_TYPE("unsupported_grant_type"),
    INVALID_SCOPE("invalid_scope")
    ;
    private final String value;

    public String getValue() {
        return value;
    }

    ErrorType(String value) {

        this.value = value;
    }

    public static ErrorType fromValue(String error) {
        if (error.equals(INVALID_REQUEST.getValue())) {
            return INVALID_REQUEST;
        }
        if (error.equals(INVALID_CLIENT.getValue())) {
            return INVALID_CLIENT;
        }
        if (error.equals(INVALID_GRANT.getValue())) {
            return INVALID_GRANT;
        }
        if (error.equals(UNAUTHORISED_CLIENT.getValue())) {
            return UNAUTHORISED_CLIENT;
        }
        if (error.equals(UNSUPPORTED_GRANT_TYPE.getValue())) {
            return UNSUPPORTED_GRANT_TYPE;
        }
        if (error.equals(INVALID_SCOPE.getValue())) {
            return INVALID_SCOPE;
        }
        return null;
    }

}

