package com.dac.sanus_api.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.dac.sanus_api.entidades.usuarios.Aluno;
import com.dac.sanus_api.entidades.usuarios.Usuario;
import com.dac.sanus_api.services.AlunoService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class TestConfig implements CommandLineRunner {

        private AlunoService alunoService;

        @Override
        public void run(String... args) throws Exception {
                var usuario01 = new Usuario(1L, true, "Alice Johnson", "alice.johnson@example.com", "password789",
                                "1122334455", "00000000000", true);
                var usuario02 = new Usuario(2L, true, "John Doe", "john.doe@example.com", "password123", "1234567890",
                                "11111111111", true);
                var usuario03 = new Usuario(3L, false, "Jane Smith", "jane.smith@example.com", "password456",
                                "0987654321", "22222222222", false);

                var aluno01 = new Aluno(usuario01);
                var aluno02 = new Aluno(usuario02);
                var aluno03 = new Aluno(usuario03);

                alunoService.salvarAluno(aluno01);
                alunoService.salvarAluno(aluno02);
                var alunoInativo = alunoService.salvarAluno(aluno03);

                alunoService.desativarConta(alunoInativo.getId());
        }

}
