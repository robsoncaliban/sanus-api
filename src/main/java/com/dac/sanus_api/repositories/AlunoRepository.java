package com.dac.sanus_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dac.sanus_api.entidades.usuarios.Aluno;
import java.util.List;


public interface AlunoRepository extends JpaRepository<Aluno, Long>{

    List<Aluno> findByAtivo(boolean ativo); 
}
