package com.dac.sanus_api.test;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.dac.sanus_api.dtos.AlunoRequestDTO;
import com.dac.sanus_api.dtos.UsuarioRequestDTO;
import com.dac.sanus_api.services.AlunoService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class TestConfig implements CommandLineRunner{

    private AlunoService alunoService;

    @Override
    public void run(String... args) throws Exception {
    
        var senha = "123456";
        UsuarioRequestDTO usuario01 = new UsuarioRequestDTO(true, "Juvenal", "juvenal@gmail",
         senha, "000000001", "13583720040");
        UsuarioRequestDTO usuario02 = new UsuarioRequestDTO(false, "Alison", "alison@gmail",
         senha, "000000002", "24792177014");
         UsuarioRequestDTO usuario03 = new UsuarioRequestDTO(false, "Pedro", "pedro@gmail",
         senha, "000000003", "37997862013");
        AlunoRequestDTO aluno01 = new AlunoRequestDTO(usuario01, "202400001");
        AlunoRequestDTO aluno02 = new AlunoRequestDTO(usuario02, "202400002");
        AlunoRequestDTO aluno03 = new AlunoRequestDTO(usuario03, "202400003");
        alunoService.inserirAluno(aluno01);
        alunoService.inserirAluno(aluno02);
        var alunoInativo = alunoService.inserirAluno(aluno03); 
        alunoService.desativarConta(alunoInativo.getId());
    }
    
}
