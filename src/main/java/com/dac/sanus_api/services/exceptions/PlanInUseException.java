package com.dac.sanus_api.services.exceptions;

public class PlanInUseException extends RuntimeException{

    public PlanInUseException(String mensage) {
        super(mensage);
    }
}
