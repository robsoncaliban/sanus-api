package com.dac.sanus_api.entidades.dtos.response;

import com.dac.sanus_api.entidades.usuarios.Usuario;

public record UsuarioResponseResumidoDto(
    String nome,
    String telefone
) {
    public UsuarioResponseResumidoDto(Usuario usuario) {
        this(usuario.getNome(), usuario.getTelefone());
    }
}
