package com.dac.sanus_api.services.exceptions;

public class DuplicateCredentialsException extends RuntimeException{
    public DuplicateCredentialsException(Long id) {
        super("Ja existe um aluno cadastrado com esse id: " + id);
    }
}
