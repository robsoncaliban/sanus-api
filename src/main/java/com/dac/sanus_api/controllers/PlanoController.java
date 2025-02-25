package com.dac.sanus_api.controllers;

import org.springframework.http.ResponseEntity;
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

    

}
