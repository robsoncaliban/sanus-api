package com.dac.sanus_api.entidades.dtos.request;

import jakarta.validation.constraints.NotNull;

public record AlunoRequestDTO(
    @NotNull
    UsuarioRequestDTO usuario,
    @NotNull
    Long planoId
    ) {

}
