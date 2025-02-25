package com.dac.sanus_api.entidades.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.dac.sanus_api.entidades.PlanoAluno;
import com.dac.sanus_api.entidades.enuns.PlanoStatus;
import com.dac.sanus_api.entidades.usuarios.Aluno;

public record AlunoResponseDto(
    UsuarioReponseDto usuarioReponseDto,
    String matricula,
    Long idPlano,
    String planoNome,
    LocalDate dataAssinatura,
    LocalDate davaVencimento,
    PlanoStatus statusDoPlano
) {
    public AlunoResponseDto(Aluno aluno, PlanoAluno planoAluno) {
        this(new UsuarioReponseDto(aluno.getUsuario()), 
        aluno.getMatricula(), planoAluno.getPlano().getId(), planoAluno.getNomePlano(),
        planoAluno.getDataAssinatura(), planoAluno.getDataVencimento(),
        planoAluno.getStatus());
    }
}
