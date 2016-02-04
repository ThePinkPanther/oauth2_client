package org.pinkpanther.oauth2.client;


/**
 * @author ben
 * @version 1.0
 */
public class Oauth2Session {

    private long updateTime = -1;
    private String accessToken;
    private String tokenType;
    private Long expiresIn;
    private String refreshToken;


    public void setGrantResponse(GrantResponse grantResponse) {
        this.updateTime = System.currentTimeMillis();
        accessToken = grantResponse.getAccessToken();
        tokenType = grantResponse.getTokenType();
        expiresIn = grantResponse.getExpiresIn();
        refreshToken = grantResponse.getRefreshToken();
    }

    public boolean sessionExpired() {
        if (updateTime == -1)
            return true;
        long currentTime = System.currentTimeMillis();
        return ( updateTime + expiresIn * 1000 ) > currentTime;
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

    public String getRefreshToken() {
        return refreshToken;
    }

    public AccessToken toToken() {
        return new AccessToken(accessToken, tokenType, expiresIn);
    }

}
