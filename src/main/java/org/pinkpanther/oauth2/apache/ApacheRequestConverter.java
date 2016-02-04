package org.pinkpanther.oauth2.apache;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.pinkpanther.oauth2.client.RequestWrapper;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author ben
 * @version 1.0
 */
public class ApacheRequestConverter {

    private HttpPost setBodyArguments(HttpPost request, Set<Entry<String, String>> arguments)
            throws UnsupportedEncodingException {
        List<NameValuePair> nvps = new LinkedList<NameValuePair>();

        for (Entry<String, String> entry : arguments) {
            nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        request.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

        return request;
    }

    public HttpRequestBase convert(RequestWrapper requestWrapper)
            throws UnsupportedEncodingException, URISyntaxException {

        HttpRequestBase request;

        // Set uri params
        URIBuilder builder = new URIBuilder(requestWrapper.getEndpoint());
        for (Entry<String, String> entry : requestWrapper.getUriArguments()) {
            builder.addParameter(entry.getKey(),entry.getValue());
        }
        URI uri = builder.build();

        switch (requestWrapper.getMethod()) {
            case GET:
                request = new HttpGet(uri);
                break;
            default:
            case POST:
                // Set Body arguments
                request = setBodyArguments(
                        new HttpPost(uri),
                        requestWrapper.getBodyArguments());
        }

        // Set Headers
        for (Entry<String,String> entry : requestWrapper.getHeaderArguments()) {
            request.addHeader(entry.getKey(), entry.getValue());
        }

        return request;
    }
}
