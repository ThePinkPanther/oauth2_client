package org.pinkpanther.oauth2.client;

/**
 * @author ben
 * @version 1.0
 */
public class AccessToken {

    private final String accessToken;
    private final String tokenType;
    private final Long expiresIn;


    public AccessToken(String accessToken, String tokenType, Long expiresIn) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

}
