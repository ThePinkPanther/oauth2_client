package org.pinkpanther.oauth2.client.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.pinkpanther.oauth2.client.ErrorResponse;
import org.pinkpanther.oauth2.client.ErrorType;
import org.pinkpanther.oauth2.client.GrantResponse;
import org.pinkpanther.oauth2.client.ResponseWrapper;

import java.io.IOException;

/**
 * @author ben
 * @version 1.0
 */
public class GrantResponseParser {

    private final int OK = 200;
    private static final ObjectMapper mapper = new ObjectMapper();

    public GrantResponse parse(ResponseWrapper responseWrapper)
            throws Oauth2ResponseException, IOException {

        if (responseWrapper.getStatus() == OK) {
            return mapper.readValue(responseWrapper.getBody(), GrantResponse.class);
        } else {
            ErrorResponse errorResponse = mapper.
                    readValue(responseWrapper.getBody(), ErrorResponse.class);
            throw new Oauth2ResponseException(
                    errorResponse,
                    ErrorType.fromValue(errorResponse.getError()));
        }
    }

}
