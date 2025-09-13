package com.auth.jwt.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class JwtResponse {

    private String issuedAt;
    private long expiration;
    private String accessToken;
}
