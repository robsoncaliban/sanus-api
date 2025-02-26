package com.dac.sanus_api.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dac.sanus_api.services.exceptions.PlanInUseException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class PlanoExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(PlanInUseException.class)
    private ResponseEntity<StandardError> planoEmUsoExceptionHandler(PlanInUseException e, HttpServletRequest request){
        String erro = "Conflict";
        Integer status = HttpStatus.CONFLICT.value();
        StandardError sError = new StandardError(Instant.now(),status,erro,e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(sError);
    }

}
