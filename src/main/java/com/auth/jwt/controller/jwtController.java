package com.auth.jwt.controller;

import com.auth.jwt.model.JwtRequest;
import com.auth.jwt.model.JwtResponse;
import com.auth.jwt.service.JwtService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Schema(description = "Controller to handle the POST HTTP request")
@RestController
@RequestMapping(value = "/jwt-utility/v1")
public class jwtController {

    @Autowired
    private JwtService jwtService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = JwtResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProblemDetail.class))})})
    @PostMapping("/token")
    public ResponseEntity<JwtResponse> getToken(@RequestBody JwtRequest request) {
        return ResponseEntity.ok(
                jwtService.jwtResponse(request)
        );
    }
}
