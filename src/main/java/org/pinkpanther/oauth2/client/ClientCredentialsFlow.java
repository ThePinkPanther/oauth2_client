package org.pinkpanther.oauth2.client;

import org.pinkpanther.oauth2.client.util.GrantResponseParser;
import org.pinkpanther.oauth2.client.util.Oauth2ResponseException;
import org.pinkpanther.oauth2.client.util.PostRequestFactory;

import java.io.IOException;

/**
 * @author ben
 * @version 1.0
 */
public class ClientCredentialsFlow extends Oauth2Flow {

    protected final String clientID;
    protected final String clientSecret;
    protected final String scope;


    public ClientCredentialsFlow(Oauth2Session session, HttpClientWrapper client, String tokenEndpoint, String authorizationEndpoint, String clientID, String clientSecret, String scope) {
        super(session, client, tokenEndpoint, authorizationEndpoint);
        this.clientID = clientID;
        this.clientSecret = clientSecret;
        this.scope = scope;
    }

    @Override
    public GrantResponse authorizeGrant() throws Oauth2ResponseException, IOException {

        GrantRequest grant = new GrantRequest();
        grant.setClientId(clientID);
        grant.setClientSecret(clientSecret);
        grant.setGrantType(GrantType.CLIENT);
        grant.setScope(scope);

        RequestWrapper request = requestFactory.convertGrantRequest(grant);

        request.setEndpoint(tokenEndpoint);

        ResponseWrapper response = sendRequest(request);

        return responseParser.parse(response);

    }

}
