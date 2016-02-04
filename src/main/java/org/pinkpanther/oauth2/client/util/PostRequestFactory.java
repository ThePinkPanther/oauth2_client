package org.pinkpanther.oauth2.client.util;

import org.pinkpanther.oauth2.client.GrantRequest;
import org.pinkpanther.oauth2.client.RequestMethod;
import org.pinkpanther.oauth2.client.RequestWrapper;

import java.io.UnsupportedEncodingException;

/**
 * @author ben
 * @version 1.0
 */
public class PostRequestFactory {


    public void authorize(RequestWrapper wrapper, GrantRequest request) {
        if (request.getClientId() != null) {
            if (request.getClientSecret() != null) {
                String authorizationString = null;
                try {
                    authorizationString = new ClientCredentialsEncoder().base64Encode(
                            request.getClientId(),
                            request.getClientSecret());
                } catch (UnsupportedEncodingException e) {
                    Logger.error(e);
                }
                wrapper.addHeaderArgument("Authorization", authorizationString);
            } else {
                wrapper.addBodyArgument("client_id", request.getClientId());
            }
        }
    }

    public RequestWrapper convertGrantRequest(GrantRequest request) {
        RequestWrapper wrapper = new RequestWrapper();
        wrapper.setMethod(RequestMethod.POST);
        // TODO only client_credentials flow support so far
        authorize(wrapper, request);
        wrapper.addBodyArgument("grant_type",request.getGrantType().getValue());
        if (request.getScope()!=null){
            wrapper.addBodyArgument("scope",request.getScope());
        }
        return wrapper;
    }

}
