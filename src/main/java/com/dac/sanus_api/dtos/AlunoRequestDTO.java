package com.dac.sanus_api.dtos;

import jakarta.validation.constraints.NotBlank;

public record AlunoRequestDTO(
    UsuarioRequestDTO usuario, 
    @NotBlank
    String matricula) {}
