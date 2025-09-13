package com.auth.jwt.controller;


import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<Object> handleException(HttpServletRequest request, Exception ex) {

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(problemDetail(request, problemDetail));

    }

    protected ProblemDetail problemDetail(HttpServletRequest request, ProblemDetail problemDetail) {

        problemDetail.setType(URI.create(request.getRequestURI() + "-error"));
        problemDetail.setProperty("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd.HH.mm.ss.SSS")));
        problemDetail.setTitle("Internal server error");
        problemDetail.setDetail("Unexpected error occurred");
        problemDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        return problemDetail;
    }

}
