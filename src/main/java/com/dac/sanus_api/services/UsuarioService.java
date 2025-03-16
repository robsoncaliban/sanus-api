package com.dac.sanus_api.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dac.sanus_api.entidades.dtos.request.UsuarioRequestDTO;
import com.dac.sanus_api.entidades.usuarios.Usuario;
import com.dac.sanus_api.repositories.UsuarioRepository;
import com.dac.sanus_api.services.exceptions.NotFoundException;
import com.dac.sanus_api.utils.Generator;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService implements UserDetailsService{

    private UsuarioRepository usuarioRepository;
    private Generator generator;

    private PasswordEncoder passwordEncoder;

    public Usuario inserirUsuario(UsuarioRequestDTO usuarioDto){
        var usuario = usuarioRepository.findByEmail(usuarioDto.email());
        if(usuario.isPresent()){
            return usuario.get();
        }
        String senhaAleatoria = generator.gerarSenhaAleatoria(15);
        
        var usuarioNovo = new Usuario(usuarioDto);
        usuarioNovo.setSenha(passwordEncoder.encode(senhaAleatoria));
        return usuarioRepository.save(usuarioNovo);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email)
            .orElseThrow(() -> new NotFoundException("Usuario com o email: " + email +" não encontrado"));
    }

    public boolean validarSenha(String senha, String encodedSenha) {
        return passwordEncoder.matches(senha, encodedSenha);
    }

}
