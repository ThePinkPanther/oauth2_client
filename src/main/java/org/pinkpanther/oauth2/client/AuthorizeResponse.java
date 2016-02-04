package org.pinkpanther.oauth2.client;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ben
 * @version 1.0
 */
public class AuthorizeResponse {

    @JsonProperty("code")
    private String code;
    @JsonProperty("state")
    private String state;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
