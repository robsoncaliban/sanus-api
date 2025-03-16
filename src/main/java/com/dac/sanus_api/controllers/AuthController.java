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
import com.dac.sanus_api.services.UsuarioService;
import com.dac.sanus_api.services.security.TokenService;

import io.jsonwebtoken.lang.Arrays;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private UsuarioService usuarioService;
    private TokenService jwtService;
    
    @PostMapping(value = "/login")
    public ResponseEntity<Void> login(@RequestBody @Valid LoginDTO login){
        var user = usuarioService.loadUserByUsername(login.email());

        var isValid = usuarioService.validarSenha(login.senha(), user.getPassword());
        if(!isValid){
            return ResponseEntity.notFound().build();
        }
        var jwt =  jwtService.generateToken(login.email(), Arrays.asList(user.getAuthorities().toArray()) );
        var jwtCookie = ResponseCookie.from("token", jwt)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .sameSite("Strict")
                .maxAge(Duration.ofDays(7))
                .build();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).build();
    }
}