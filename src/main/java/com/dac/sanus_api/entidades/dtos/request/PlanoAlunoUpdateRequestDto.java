package com.dac.sanus_api.entidades.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PlanoAlunoUpdateRequestDto(@NotBlank String matricula, @NotNull Long idPlanoNovo) {
        
}
