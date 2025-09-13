package com.auth.jwt.exception;

import lombok.Getter;

@Getter
public class JwtException extends RuntimeException {

    private final String errorMessage;

    public JwtException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
