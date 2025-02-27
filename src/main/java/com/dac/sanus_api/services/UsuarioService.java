package com.dac.sanus_api.services;

import org.springframework.stereotype.Service;

import com.dac.sanus_api.entidades.dtos.request.UsuarioRequestDto;
import com.dac.sanus_api.entidades.usuarios.Usuario;
import com.dac.sanus_api.repositories.UsuarioRepository;
import com.dac.sanus_api.utils.Generator;

@Service
public class UsuarioService {

    private UsuarioRepository repository;
    private Generator generator;

    public UsuarioService(UsuarioRepository repository, Generator generator) {
        this.repository = repository;
        this.generator = generator;
    }


    public Usuario inserirUsuario(UsuarioRequestDto usuarioDto){
        var usuario = repository.findByEmail(usuarioDto.email());
        if(usuario.isPresent()){
            return usuario.get();
        }
        String senhaAleatoria = generator.gerarSenhaAleatoria(15);
        var usuarioNovo = new Usuario(usuarioDto);
        usuarioNovo.setSenha(senhaAleatoria);
        return repository.save(usuarioNovo);
    }

}
