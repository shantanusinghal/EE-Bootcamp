package com.ee.security;

import com.thirdparty.security.IdReader;
import com.thirdparty.security.ReaderResponse;

public class SecuritySystem {

    private final IdReader idReader;
    private final Authenticator authenticator;

    public SecuritySystem(IdReader idReader, Authenticator authenticator) {
        this.idReader = idReader;
        this.authenticator = authenticator;
    }

    public boolean processScan() {
        ReaderResponse response = idReader.read();
        if(authenticator.authenticate(response.getRole(), response.getId())) {
            return idReader.open();
        }
        return false;
    }

}
