package com.adeo.conf;

public interface SecurityParams {
    String JWT_HEADER_NAME = "Authorization";
    String SECRET = "a.boucetta@hotmail.fr";
    long EXPIRATION = 10*24*3600*1000;
    String HEADER_PREFIX = "Bearer ";
}
