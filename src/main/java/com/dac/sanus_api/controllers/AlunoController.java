package com.dac.sanus_api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dac.sanus_api.entidades.dtos.request.AlunoRequestDto;
import com.dac.sanus_api.entidades.dtos.response.AlunoReponseResumidoDto;
import com.dac.sanus_api.entidades.dtos.response.AlunoResponseDto;
import com.dac.sanus_api.entidades.usuarios.Aluno;
import com.dac.sanus_api.services.AlunoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/alunos")
@AllArgsConstructor
public class AlunoController {
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoReponseResumidoDto> criarAluno(
        @RequestBody @Valid AlunoRequestDto alunoRequestDTO){
        var alunoNovo = alunoService.inserirAluno(alunoRequestDTO);
        var responseDto = new AlunoReponseResumidoDto(alunoNovo);
        return ResponseEntity.ok().body(responseDto);
    }
    
    @GetMapping
    public ResponseEntity<List<AlunoReponseResumidoDto>> listarAlunos(
        @PageableDefault(page = 0, size = 10) Pageable page
    ){
        var alunos = alunoService.buscarTodos(page);
        List<AlunoReponseResumidoDto> alunosResponse = new ArrayList<>();
        for (Aluno aluno : alunos) {
            AlunoReponseResumidoDto responseDto = new AlunoReponseResumidoDto(aluno);
            alunosResponse.add(responseDto);
        }
        return ResponseEntity.ok().body(alunosResponse);
    }

    @GetMapping(value = "/{matricula}")
    public ResponseEntity<AlunoResponseDto> buscarAlunoPorMatricula(@PathVariable String matricula){
        var aluno = alunoService.buscarAlunoPorMatricula(matricula);
        var responseDto = new AlunoResponseDto(aluno, aluno.getPlanoAluno());
        return ResponseEntity.ok().body(responseDto);
    }

}
