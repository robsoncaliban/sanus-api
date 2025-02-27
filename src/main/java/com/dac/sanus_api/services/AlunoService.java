package com.dac.sanus_api.services;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dac.sanus_api.entidades.Plano;
import com.dac.sanus_api.entidades.PlanoAluno;
import com.dac.sanus_api.entidades.dtos.request.AlunoRequestDto;
import com.dac.sanus_api.entidades.usuarios.Aluno;
import com.dac.sanus_api.entidades.usuarios.Usuario;
import com.dac.sanus_api.repositories.AlunoRepository;
import com.dac.sanus_api.services.exceptions.DuplicateCredentialsException;
import com.dac.sanus_api.services.exceptions.NotFoundException;
import com.dac.sanus_api.utils.Generator;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlunoService {
    
    private AlunoRepository alunoRepository;
    private UsuarioService usuarioService;
    private PlanoService planoService;
    private Generator generator;

    @Transactional
    public Aluno inserirAluno(AlunoRequestDto alunoDto){
        Usuario usuario = usuarioService.inserirUsuario(alunoDto.usuario());
        
        if (alunoRepository.findById(usuario.getId()).isPresent()) {
            throw new DuplicateCredentialsException(usuario.getId());
        }
        Plano plano = planoService.buscarPlanoPorId(alunoDto.planoId());
            
        String matriculaGerada = gerarMatricula();
        String senhaAleatoria = generator.gerarSenhaAleatoria(15);
        var alunoNovo = new Aluno(usuario, matriculaGerada);
        alunoNovo.getUsuario().setSenha(senhaAleatoria);
        var planoAluno = new PlanoAluno(alunoNovo, plano);
        alunoNovo.setPlanoAluno(planoAluno);

        return alunoRepository.save(alunoNovo);
    }
    private String gerarMatricula(){
        String ano = String.valueOf(LocalDate.now().getYear());
        String ultimaMatricula = alunoRepository.findUltimaMatriculaPorAno(ano);
        return generator.gerarMatricula(ultimaMatricula);
    }    

    public Aluno buscarAlunoPorMatricula(String matricula){
        return alunoRepository.findByMatricula(matricula)
            .orElseThrow(() -> new NotFoundException("O aluno com essa matricula: "+ matricula+ " não existe."));
    }

    public Page<Aluno> buscarTodos(Pageable page){
        return alunoRepository.findAll(page);
    }

}
