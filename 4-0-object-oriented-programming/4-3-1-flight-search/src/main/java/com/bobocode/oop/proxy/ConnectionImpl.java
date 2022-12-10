package com.bobocode.oop.proxy;

public class ConnectionImpl implements Connection{
    private WebClient client;

    public ConnectionImpl() {
        client = new WebClient();
    }

    public void connectTo(String dest) throws AbadonedConnectionException {
        client.connect(dest);
    }

    public static class WebClient {
        //implementation of web client
        //maybe singleton should be
        public void connect(String ip) {
        }
    }
}
