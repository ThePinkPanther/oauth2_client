package org.pinkpanther.oauth2.client;

/**
 * @author ben
 * @version 1.0
 */
public class ResponseWrapper {

    private final String body;
    private final int status;

    public String getBody() {
        return body;
    }

    public int getStatus() {
        return status;
    }

    public ResponseWrapper(String body, int code) {
        this.body = body;
        this.status = code;
    }

}
