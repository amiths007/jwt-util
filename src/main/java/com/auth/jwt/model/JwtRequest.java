package com.auth.jwt.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Fields for JWT request")
@Data
public class JwtRequest {

    @Schema(example = "RS256")
    private String alg;
    @Schema(example = "jwt")
    private String typ;
    @Schema( example = "audience")
    private String aud;
}
