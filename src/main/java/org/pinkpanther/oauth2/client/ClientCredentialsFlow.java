package org.pinkpanther.oauth2.client;

import org.pinkpanther.oauth2.client.util.GrantResponseParser;
import org.pinkpanther.oauth2.client.util.Oauth2Exception;
import org.pinkpanther.oauth2.client.util.Oauth2ResponseException;
import org.pinkpanther.oauth2.client.util.PostRequestFactory;

import java.io.IOException;
import java.net.URISyntaxException;

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
    public GrantResponse authorizeGrant() throws Oauth2Exception, IOException {

        GrantRequest grant = new GrantRequest();
        grant.setClientId(clientID);
        grant.setClientSecret(clientSecret);
        grant.setGrantType(GrantType.CLIENT);
        grant.setScope(scope);

        RequestWrapper request = requestFactory.convertGrantRequest(grant);

        request.setEndpoint(tokenEndpoint);

        ResponseWrapper response = null;
        try {
            response = sendRequest(request);
        } catch (URISyntaxException e) {
            throw new Oauth2Exception(e.getMessage(),e);
        }

        return responseParser.parse(response);

    }

}
