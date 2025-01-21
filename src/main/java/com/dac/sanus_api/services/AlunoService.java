package com.dac.sanus_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dac.sanus_api.dtos.AlunoRequestDTO;
import com.dac.sanus_api.entidades.usuarios.Aluno;
import com.dac.sanus_api.repositories.AlunoRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlunoService {
    
    private AlunoRepository repository;
    private UsuarioService usuarioService;

    //TODO: Refatorar
    public Optional<Aluno> buscarAlunoPorId(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Aluno inserirAluno(AlunoRequestDTO alunoDto){
        var usurio = usuarioService.inserirUsuario(alunoDto.usuario());    
        if(buscarAlunoPorId(usurio.getId()).isPresent()){
            //TODO: retorna exception personalizada
            return null;
        }
        Aluno aluno = new Aluno(usurio, alunoDto.matricula());
        return repository.save(aluno);
    }

    public List<Aluno> buscarAlunosAtivos(){
        return repository.findByAtivo(true);
    }

    public void desativarConta(Long id){
        var aluno = buscarAlunoPorId(id).get();
        aluno.setAtivo(false);
        repository.save(aluno);
    }
}
