package com.dac.sanus_api.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dac.sanus_api.services.exceptions.DuplicateCredentialsException;
import com.dac.sanus_api.services.exceptions.NotFoundException;

import jakarta.servlet.http.HttpServletRequest;

public class DefaultExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(DuplicateCredentialsException.class)
    private ResponseEntity<StandardError> dadoJaCadastradoHandler(DuplicateCredentialsException e, HttpServletRequest request){
        String erro = "Conflict";
        Integer status = HttpStatus.CONFLICT.value();
        StandardError sError = new StandardError(Instant.now(),status,erro,e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(sError);
    }

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<StandardError> naoEncontradoHandler(NotFoundException e, HttpServletRequest request){
        String erro = "Not found";
        Integer status = HttpStatus.NOT_FOUND.value();
        StandardError sError = new StandardError(Instant.now(), status, erro, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(sError);
    }

}
