package com.dac.sanus_api.services.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.dac.sanus_api.entidades.dtos.request.LoginDTO;
import com.dac.sanus_api.services.UsuarioService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthService {

        private final UsuarioService usuarioService;
        private final TokenService tokenService;

        public String autenticar(LoginDTO loginDTO) {
                var usuario = usuarioService.loadUserByUsername(loginDTO.email());
                System.out.println(usuario);

                var isValida = usuarioService.validarSenha(loginDTO.senha(), usuario.getPassword());
                if (!isValida) {
                        throw new BadCredentialsException("Senha inválida");
                }

                return tokenService.gerarToken(usuario);
        }
}
