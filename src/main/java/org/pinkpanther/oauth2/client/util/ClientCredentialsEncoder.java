package org.pinkpanther.oauth2.client.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * @author ben
 * @version 1.0
 */
public class ClientCredentialsEncoder {

    public String base64Encode(String clientId, String password) throws UnsupportedEncodingException {
        byte[] encodedBytes = Base64.encodeBase64(
                (clientId + ":" + password)
                        .getBytes("utf-8")
        );
        return "Basic " + new String(encodedBytes);
    }

}
