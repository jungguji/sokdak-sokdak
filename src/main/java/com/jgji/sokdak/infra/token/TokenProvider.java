package com.jgji.sokdak.infra.token;

public interface TokenProvider {

    String generateJwtToken(String username);
    String getUsernameFromJwtToken(String token);
    boolean validateJwtToken(String authToken);
}
