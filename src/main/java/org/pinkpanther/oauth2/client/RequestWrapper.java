package org.pinkpanther.oauth2.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author ben
 * @version 1.0
 */
public class RequestWrapper {

    public RequestWrapper() {
        // Headers requred by default
        addHeaderArgument("Accept", "*/*");
        addHeaderArgument("Content-Type", "application/x-www-form-urlencoded");
    }

    private String endpoint;
    private RequestMethod method;
    private final Map<String, String> uriArguments = new HashMap<String, String>();
    private final Map<String, String> bodyArguments = new HashMap<String, String>();
    private final Map<String, String> headerArguments = new HashMap<String, String>();

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    public void addHeaderArgument(String name, String value) {
        headerArguments.put(name, value);
    }

    public void addBodyArgument(String name, String value) {
        bodyArguments.put(name, value);
    }

    public void addUriArgument(String name, String value) {
        uriArguments.put(name, value);
    }

    public Set<Entry<String, String>> getHeaderArguments() {
        return headerArguments.entrySet();
    }

    public Set<Entry<String, String>> getBodyArguments() {
        return bodyArguments.entrySet();
    }

    public Set<Entry<String, String>> getUriArguments() {
        return uriArguments.entrySet();
    }

}
