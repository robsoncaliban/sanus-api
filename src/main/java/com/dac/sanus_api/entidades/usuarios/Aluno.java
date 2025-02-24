package com.dac.sanus_api.entidades.usuarios;

import java.io.Serializable;


import com.dac.sanus_api.entidades.PlanoAluno;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_ALUNO")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ToString.Exclude
    @OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL)
    private PlanoAluno planoAluno;
    
    @Column(unique = true, nullable = false)
    private String matricula;
    
    public Aluno(Usuario usuario, String matricula) {
        this.usuario = usuario;
        this.matricula = matricula;
    }  
}
