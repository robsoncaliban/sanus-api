package com.dac.sanus_api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dac.sanus_api.entidades.Plano;
import com.dac.sanus_api.entidades.dtos.request.PlanoRequestDto;
import com.dac.sanus_api.repositories.PlanoRepository;
import com.dac.sanus_api.services.exceptions.NotFoundException;
import com.dac.sanus_api.services.exceptions.PlanInUseException;

@Service
public class PlanoService {
    
    private PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public Plano criarPlano(PlanoRequestDto planoDto){
        var planoNovo = new Plano(planoDto);
        return planoRepository.save(planoNovo);
    }

    public void deletarPlano(Long id){
        var plano = buscarPlanoPorId(id);
        if(plano.getPlanosAluno().isEmpty()){
            planoRepository.delete(plano);
        }
        throw new PlanInUseException("O plano está sendo usado");
    }

    public Plano buscarPlanoPorId(Long id){
        return planoRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Plano não encontrado"));
    }

    public Page<Plano> buscarTodos(Pageable page){
        return planoRepository.findAll(page);
    }
}
