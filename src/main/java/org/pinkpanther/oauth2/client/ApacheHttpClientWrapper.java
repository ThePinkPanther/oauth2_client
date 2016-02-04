package org.pinkpanther.oauth2.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.BasicResponseHandler;

import java.io.IOException;

/**
 * @author ben
 * @version 1.0
 */
public class ApacheHttpClientWrapper implements HttpClientWrapper {

    private final HttpClient client;

    public ApacheHttpClientWrapper(HttpClient client) {
        this.client = client;
    }

    public ResponseWrapper send(RequestWrapper requestWrapper) throws IOException {

        HttpRequestBase request;
        switch (requestWrapper.getMethod()) {
            case GET:
                request = new HttpGet(requestWrapper.getEndpoint());
                break;
            default:
            case POST:
                request = new HttpPost(requestWrapper.getEndpoint());
                break;
        }

        HttpResponse response = client.execute(request);

        BasicResponseHandler handler = new BasicResponseHandler();

        String body = handler.handleResponse(response);
        int status = response.getStatusLine().getStatusCode();

        return new ResponseWrapper(body, status);
    }

}
