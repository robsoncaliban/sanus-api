package com.dac.sanus_api.entidades.dtos.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record PlanoRequestDto(
    @NotBlank
    String nome,
    @NotBlank
    String descricao,
    @Positive
    int duracaoMesses,
    @Positive
    int diasSemanaisDisponiveis,
    @NotNull
    @Positive
    BigDecimal valor,
    @PositiveOrZero
    int congelamentoDias
) {

}
