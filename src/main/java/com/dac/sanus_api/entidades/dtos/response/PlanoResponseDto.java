package com.dac.sanus_api.entidades.dtos.response;

import java.math.BigDecimal;

import com.dac.sanus_api.entidades.Plano;

public record PlanoResponseDto(
    String nome,
    String descricao,
    BigDecimal valor,
    int diasSemanaisDisponiveis,
    int congelamentoDias,
    int duracaoMesses
) {
    public PlanoResponseDto(Plano plano) {
        this(plano.getNome(), plano.getDescricao(), plano.getValor(),
        plano.getDiasSemanaisDisponiveis(), plano.getCongelamentoDias(), plano.getDuracaoMesses());
    }
}
