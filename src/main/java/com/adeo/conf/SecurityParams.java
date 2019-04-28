package com.adeo.conf;

abstract class SecurityParams {
    static final String JWT_HEADER_NAME = "Authorization";
    static final String SECRET = "a.boucetta@hotmail.fr";
    static final long EXPIRATION = 864000000;
    static final String HEADER_PREFIX = "Bearer ";

    private SecurityParams() {
    }
}
