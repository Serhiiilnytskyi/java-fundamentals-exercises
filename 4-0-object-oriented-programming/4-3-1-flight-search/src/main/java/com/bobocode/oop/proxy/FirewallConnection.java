package com.bobocode.oop.proxy;

import java.util.List;

public class FirewallConnection extends ConnectionImpl{

    private List<String> bannedDestinations;

    public FirewallConnection(List<String> bannedDestinations) {
        this.bannedDestinations = bannedDestinations;
    }

    @Override
    public void connectTo(String dest) throws AbadonedConnectionException {
        if (!bannedDestinations.contains(dest)) {
            super.connectTo(dest);
        } else {
            throw new AbadonedConnectionException();
        }
    }
}
