package com.dac.sanus_api.dtos;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(
    @NotBlank
    String nome,
    @Email 
    String email,
    @NotBlank
    @Size(min = 5, max = 12) 
    String senha,
    @NotBlank 
    String telefone,
    @CPF 
    String cpf) {

}
