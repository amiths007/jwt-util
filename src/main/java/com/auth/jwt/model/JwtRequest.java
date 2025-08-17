package com.auth.jwt.model;

import lombok.Data;

@Data
public class JwtRequest {

    private String alg;
    private String typ;
    private String aud;
}
