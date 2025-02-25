package com.dac.sanus_api.controllers;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dac.sanus_api.entidades.dtos.request.PlanoRequestDto;
import com.dac.sanus_api.entidades.dtos.response.PlanoResponseDto;
import com.dac.sanus_api.services.PlanoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/planos")
@AllArgsConstructor
public class PlanoController {
    
    private PlanoService planoService;

    @PostMapping
    public ResponseEntity<PlanoResponseDto> criarPlano(@RequestBody @Valid PlanoRequestDto planoRequestDto){
        var novoPlano = planoService.criarPlano(planoRequestDto);
        var responseDto = new PlanoResponseDto(novoPlano);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PlanoResponseDto> buscarPlanoPorId(@PathVariable Long id){
        var plano = planoService.buscarPlanoPorId(id);
        var responseDto = new PlanoResponseDto(plano);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<PlanoResponseDto>> buscarTodos(@PageableDefault(page = 0, size = 10) Pageable page){
        var planos = planoService.buscarTodos(page);
        List<PlanoResponseDto> planosResponses = planos.map(PlanoResponseDto::new).toList();
        return ResponseEntity.ok().body(planosResponses);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarPlanoPorId(@PathVariable Long id){
        planoService.deletarPlano(id);
        return ResponseEntity.noContent().build();
    }

}
