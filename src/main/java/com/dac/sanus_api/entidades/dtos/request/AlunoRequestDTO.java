package com.dac.sanus_api.entidades.dtos.request;

import jakarta.validation.constraints.NotNull;

public record AlunoRequestDto(
    @NotNull
    UsuarioRequestDto usuario,
    @NotNull
    Long planoId
    ) {

}
