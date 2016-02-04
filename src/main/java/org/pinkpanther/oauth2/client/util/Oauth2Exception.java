package org.pinkpanther.oauth2.client.util;

/**
 * @author ben
 * @version 1.0
 */
public class Oauth2Exception extends Exception {

    public Oauth2Exception(String errorDescription) {
        super(errorDescription);
    }

    public Oauth2Exception(String message, Throwable cause) {
        super(message, cause);
    }

}
