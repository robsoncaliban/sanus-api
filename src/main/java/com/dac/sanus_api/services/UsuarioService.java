package com.dac.sanus_api.services;

import org.springframework.stereotype.Service;

import com.dac.sanus_api.entidades.dtos.request.UsuarioRequestDto;
import com.dac.sanus_api.entidades.usuarios.Usuario;
import com.dac.sanus_api.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }


    public Usuario inserirUsuario(UsuarioRequestDto usuarioDto){
        var usuario = repository.findByEmail(usuarioDto.email());
        if(usuario.isPresent()){
            return usuario.get();
        }
        var usuarioNovo = new Usuario(usuarioDto);
        return repository.save(usuarioNovo);
    }

}
