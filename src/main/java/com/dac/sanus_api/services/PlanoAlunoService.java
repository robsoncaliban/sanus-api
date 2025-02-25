package com.dac.sanus_api.services;


import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.dac.sanus_api.entidades.Plano;
import com.dac.sanus_api.entidades.PlanoAluno;
import com.dac.sanus_api.entidades.usuarios.Aluno;
import com.dac.sanus_api.repositories.PlanoAlunoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlanoAlunoService {
    
    PlanoAlunoRepository planoAlunoRepository;

    AlunoService alunoService;
    PlanoService planoService;

    public PlanoAluno atualizarPlanoDoAluno(String matricula, Long idPlano){
        Plano plano = planoService.buscarPlanoPorId(idPlano);
        Aluno aluno = alunoService.buscarAlunoPorMatricula(matricula);
        PlanoAluno planoAluno = aluno.getPlanoAluno(); 
        planoAluno.setPlano(plano);
        planoAluno.setDataAssinatura(LocalDate.now());
        return planoAlunoRepository.save(planoAluno);
    }
}
