package com.dac.sanus_api.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dac.sanus_api.entidades.dtos.request.UsuarioRequestDTO;
import com.dac.sanus_api.entidades.usuarios.Role;
import com.dac.sanus_api.entidades.usuarios.Usuario;
import com.dac.sanus_api.repositories.UsuarioRepository;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class InitConfig implements CommandLineRunner {

        UsuarioRepository usuarioRepository;
        PasswordEncoder passwordEncoder;

        @Override
        public void run(String... args) throws Exception {
                var usuario = new Usuario(
                                new UsuarioRequestDTO(true, "robin", "robin@gmail.com", "81989065521", "13788378433"));
                usuario.setSenha(passwordEncoder.encode("1234"));

                usuario.setRoles(Set.of(new Role("ADMIN")));

                usuarioRepository.save(usuario);

        }

}
