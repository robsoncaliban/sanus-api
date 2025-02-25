package com.dac.sanus_api.entidades.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.dac.sanus_api.entidades.PlanoAluno;
import com.dac.sanus_api.entidades.enuns.PlanoStatus;
import com.dac.sanus_api.entidades.usuarios.Aluno;

public record AlunoResponseDto(
    UsuarioReponseDto usuarioReponseDto,
    String matricula,
    String nomeDoPlano,
    String descricaoDoPlano,
    int diasSemanaisDisponiveis,
    BigDecimal valorDoPlano,
    int congelamentoDias,
    LocalDate dataAssinatura,
    LocalDate davaVencimento,
    PlanoStatus statusDoPlano
) {
    public AlunoResponseDto(Aluno aluno, PlanoAluno planoAluno) {
        this(new UsuarioReponseDto(aluno.getUsuario()),
            aluno.getMatricula(), planoAluno.getPlano().getNome(), planoAluno.getPlano().getDescricao(),
            planoAluno.getPlano().getDiasSemanaisDisponiveis(), planoAluno.getPlano().getValor(),
            planoAluno.getPlano().getCongelamentoDias(),
            planoAluno.getDataAssinatura(), planoAluno.getDataVencimento(),
            planoAluno.getStatus());
    }
}
