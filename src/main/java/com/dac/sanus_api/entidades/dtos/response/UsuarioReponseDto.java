package com.dac.sanus_api.entidades.dtos.response;

import com.dac.sanus_api.entidades.usuarios.Usuario;

public record UsuarioReponseDto(
    Long id,
    boolean admin,
    boolean ativo,
    String nome,
    String email,
    String telefone,
    String cpf
) {
    public UsuarioReponseDto(Usuario usuario) {
        this(usuario.getId(), usuario.isAdmin(), usuario.isAtivo(), usuario.getNome(),
         usuario.getEmail(), usuario.getTelefone(), usuario.getCpf());
    }
}
