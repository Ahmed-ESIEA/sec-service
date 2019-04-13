package com.adeo.conf;

public interface SecurityParams {
    String JWT_HEADER_NAME = "Authorization";
    String SECRET = "a.boucetta@hotmail.fr";
    long EXPIRATION = 1000 * 3600;
    String HEADER_PREFIX = "Bearer ";
}
