package org.pinkpanther.oauth2.client;

import org.pinkpanther.oauth2.client.util.GrantResponseParser;
import org.pinkpanther.oauth2.client.util.Oauth2ResponseException;
import org.pinkpanther.oauth2.client.util.PostRequestFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;

/**
 * @author ben
 * @version 1.0
 */
public abstract class Oauth2Flow {

    private final Oauth2Session session;
    private final HttpClientWrapper client;
    protected final String tokenEndpoint;
    protected final String authorizationEndpoint;

    /*
     * Utilities
     */
    protected final static GrantResponseParser responseParser = new GrantResponseParser();
    protected final static PostRequestFactory requestFactory = new PostRequestFactory();

    protected ResponseWrapper sendRequest(RequestWrapper request) throws IOException {
        return client.send(request);
    }

    public Oauth2Flow(Oauth2Session session, HttpClientWrapper client, String tokenEndpoint, String authorizationEndpoint) {
        this.session = session;
        this.client = client;
        this.tokenEndpoint = tokenEndpoint;
        this.authorizationEndpoint = authorizationEndpoint;
    }

    public AccessToken refreshToken(String refreshToken) {
        //TODO
        throw new NotImplementedException();
    }

    public AccessToken grant() throws Oauth2ResponseException, IOException {
        if (session.sessionExpired()) {
            String refreshToken = session.getRefreshToken();
            if (refreshToken != null) {
                return refreshToken(refreshToken);
            } else {
                session.setGrantResponse(authorizeGrant());
                return session.toToken();
            }
        } else {
            return session.toToken();
        }
    }

    public abstract GrantResponse authorizeGrant() throws Oauth2ResponseException, IOException;

}
