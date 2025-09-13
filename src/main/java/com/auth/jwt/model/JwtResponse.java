package com.auth.jwt.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(description = "Fields for JWT response")
@Builder
@Data
public class JwtResponse {

    @Schema(example = "20250913")
    private String issuedAt;
    @Schema(example = "1757769014872")
    private long expiration;
    @Schema(example = "kjbcdkjbckjsbcsk.zjcjhbdcjsgdgjfsbfjsdbfsmfvdsfv")
    private String accessToken;
}
