package com.dac.sanus_api.services.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String mensage) {
        super(mensage);
    }
}
