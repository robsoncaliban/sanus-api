package com.dac.sanus_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dac.sanus_api.entidades.usuarios.Aluno;
import com.dac.sanus_api.entidades.usuarios.Usuario;
import com.dac.sanus_api.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario inserirUsuario(Aluno aluno) {
        var usuario = repository.findByEmail(aluno.getUsuario().getEmail());

        if (usuario.isPresent()) {
            var usuarioExistente = usuario.get();
            BeanUtils.copyProperties(aluno.getUsuario(), usuarioExistente, "id");
            System.err.println();
            return repository.save(usuarioExistente);
        }

        var usuarioNovo = new Usuario();
        BeanUtils.copyProperties(aluno.getUsuario(), usuarioNovo, "id");

        return repository.save(usuarioNovo);
    }

    public List<Usuario> buscarAlunos() {
        return repository.findAll();
    }

    public Page<Usuario> buscarAlunos(Pageable page) {
        return repository.findAll(page);
    }

}
