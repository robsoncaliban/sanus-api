package com.dac.sanus_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dac.sanus_api.entidades.usuarios.Aluno;
import com.dac.sanus_api.repositories.AlunoRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlunoService {

    private AlunoRepository repository;
    private UsuarioService usuarioService;

    public Optional<Aluno> buscarAlunoPorId(Long id) {
        return repository.findById(id);

    }

    public List<Aluno> buscarTodosAlunos() {
        return repository.findAll();
    }
    public Page<Aluno> buscarTodosAlunos(Pageable page){
        return repository.findAll(page);
    }

    @Transactional
    public Aluno salvarAluno(Aluno aluno) {

        var usuario = usuarioService.inserirUsuario(aluno);

        Optional<Aluno> existingAluno = buscarAlunoPorId(usuario.getId());

        if (existingAluno.isPresent()) {
            Aluno existing = existingAluno.get();
            existing.setUsuario(usuario);
            return repository.save(existing);
        } else {
            Aluno novoAluno = new Aluno(usuario);
            return repository.save(novoAluno);
        }
    }

    public List<Aluno> buscarAlunosAtivos() {
        return repository.findByAtivo(true);
    }

    public Page<Aluno> buscarAlunosAtivos(Pageable page) {
        return repository.findByAtivo(true, page);
    }

    public void desativarConta(Long id) {
        var aluno = buscarAlunoPorId(id).get();
        aluno.setAtivo(false);
        repository.save(aluno);
    }
}
