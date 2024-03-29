package org.pinkpanther.oauth2.client;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author ben
 * @version 1.0
 */
public interface HttpClientWrapper {

    public ResponseWrapper send(RequestWrapper request) throws IOException, URISyntaxException;

}
