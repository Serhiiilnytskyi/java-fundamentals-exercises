package com.bobocode.oop.proxy;

public interface Connection {
    public void connectTo(String dest) throws AbadonedConnectionException;
}
