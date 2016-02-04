package org.pinkpanther.oauth2.client.util;

import org.pinkpanther.oauth2.client.ErrorResponse;
import org.pinkpanther.oauth2.client.ErrorType;

/**
 * @author ben
 * @version 1.0
 */
public class Oauth2ResponseException extends Oauth2Exception {

    private final ErrorResponse errorResponse;
    private final ErrorType errorType;


    public Oauth2ResponseException(ErrorResponse errorResponse, ErrorType errorType) {
        super(errorResponse.getErrorDescription());
        this.errorResponse = errorResponse;
        this.errorType = errorType;
    }
}
