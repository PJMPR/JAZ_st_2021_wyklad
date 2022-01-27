package com.example.demo.contract;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
