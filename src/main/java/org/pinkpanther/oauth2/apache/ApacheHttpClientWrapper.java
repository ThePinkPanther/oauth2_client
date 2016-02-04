package org.pinkpanther.oauth2.apache;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.util.EntityUtils;
import org.pinkpanther.oauth2.client.HttpClientWrapper;
import org.pinkpanther.oauth2.client.RequestWrapper;
import org.pinkpanther.oauth2.client.ResponseWrapper;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author ben
 * @version 1.0
 */
public class ApacheHttpClientWrapper implements HttpClientWrapper {

    private final HttpClient client;
    private final static ApacheRequestConverter converter = new ApacheRequestConverter();

    public ApacheHttpClientWrapper(HttpClient client) {
        this.client = client;
    }

    public ResponseWrapper send(RequestWrapper requestWrapper) throws IOException, URISyntaxException {

        HttpRequestBase request = converter.convert(requestWrapper);

        HttpResponse response = client.execute(request);

        String body = EntityUtils.toString(response.getEntity());

        int status = response.getStatusLine().getStatusCode();

        return new ResponseWrapper(body, status);
    }

}
