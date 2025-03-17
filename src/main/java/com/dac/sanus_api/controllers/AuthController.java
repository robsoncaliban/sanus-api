package com.dac.sanus_api.controllers;

import java.time.Duration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dac.sanus_api.entidades.dtos.request.LoginDTO;
import com.dac.sanus_api.services.security.AuthService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<Void> login(@RequestBody @Valid LoginDTO login) {

        var token = authService.autenticar(login);

        var tokenCookie = ResponseCookie.from("token", token)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .sameSite("Strict")
                .maxAge(Duration.ofDays(7))
                .build();

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,
                tokenCookie.toString()).build();
    }
}