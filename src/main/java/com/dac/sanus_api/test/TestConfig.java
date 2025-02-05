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
                var usuario01 = new Usuario(true, "Alice Johnson", "alice.johnson@example.com", "password789",
                                "1122334455", "00000000000", "F", true);
                var usuario02 = new Usuario(true, "John Doe", "john.doe@example.com", "password123", "1234567890",
                                "11111111111", "M",true);
                var usuario03 = new Usuario(false, "Jane Smith", "jane.smith@example.com", "password456",
                                "0987654321", "22222222222","M", false);
                var usuario04 = new Usuario(false, "Carlos Smith", "carlos.smith@example.com", "password456",
                                "0987654331", "22222252222","M", false);
                var usuario05 = new Usuario(false, "Marcio Smith", "marcio.smith@example.com", "password456",
                                "0987654341", "22222242222","M", false);   
                var usuario06 = new Usuario(false, "Otavio Smith", "otavio.smith@example.com", "password456",
                                "0987654351", "22222232222","M", false);             

                var aluno01 = new Aluno(usuario01);
                var aluno02 = new Aluno(usuario02);
                var aluno03 = new Aluno(usuario03);
                var aluno04 = new Aluno(usuario04);
                var aluno05 = new Aluno(usuario05);
                var aluno06 = new Aluno(usuario06);

                alunoService.salvarAluno(aluno01);
                alunoService.salvarAluno(aluno02);
                alunoService.salvarAluno(aluno03);
                alunoService.salvarAluno(aluno04);
                alunoService.salvarAluno(aluno05);
                alunoService.salvarAluno(aluno06);
        }

}
