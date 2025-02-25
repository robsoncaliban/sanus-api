package com.dac.sanus_api.entidades.dtos.request;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDto(
    boolean admin,
    @NotBlank
    String nome,
    @Email 
    @NotBlank
    String email,
    @NotBlank 
    String telefone,
    @CPF 
    @NotBlank
    String cpf) {

}
