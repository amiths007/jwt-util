package com.auth.jwt.controller;

import com.auth.jwt.model.JwtRequest;
import com.auth.jwt.model.JwtResponse;
import com.auth.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/jwt-utility/v1")
public class jwtController {

    @Autowired
    private JwtService jwtService;

    @GetMapping("/token")
    public ResponseEntity<JwtResponse> getToken(@RequestBody JwtRequest request) {
        return ResponseEntity.ok(
                jwtService.jwtResponse(request)
        );
    }
}
