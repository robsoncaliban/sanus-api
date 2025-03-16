package com.dac.sanus_api.entidades.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
    @NotBlank
    String email,
    @NotBlank
    String senha) {

}
