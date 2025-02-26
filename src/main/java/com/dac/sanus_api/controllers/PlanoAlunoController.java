package com.dac.sanus_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dac.sanus_api.entidades.PlanoAluno;
import com.dac.sanus_api.entidades.dtos.response.AlunoResponseDto;
import com.dac.sanus_api.services.PlanoAlunoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/alunos/planos")
public class PlanoAlunoController {
    
    private PlanoAlunoService planoAlunoService;

    @PutMapping
    public ResponseEntity<AlunoResponseDto> updatePlanoDoAluno(@RequestBody String matricula, @RequestBody Long idPlanoNovo){
        PlanoAluno planoAluno = planoAlunoService.atualizarPlanoDoAluno(matricula, idPlanoNovo);
        var responseDto = new AlunoResponseDto(planoAluno.getAluno(), planoAluno);
        return ResponseEntity.ok().body(responseDto);
    }

}
