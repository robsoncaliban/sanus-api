package com.dac.sanus_api.entidades.dtos.response;

import com.dac.sanus_api.entidades.enuns.PlanoStatus;
import com.dac.sanus_api.entidades.usuarios.Aluno;

public record AlunoReponseResumidoDto(
    UsuarioResponseResumidoDto usuario,
    String matricula,
    String nomePlano,
    PlanoStatus planoStatus
) {
    public AlunoReponseResumidoDto(Aluno aluno) {
        this(new UsuarioResponseResumidoDto(aluno.getUsuario()),
        aluno.getMatricula(),
        aluno.getPlanoAluno().getNomePlano(),
        aluno.getPlanoAluno().getStatus());
    }
}
