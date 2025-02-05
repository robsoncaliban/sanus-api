package com.dac.sanus_api.entidades.usuarios;

import java.io.Serializable;
import com.dac.sanus_api.entidades.PlanoAluno;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @OneToOne(mappedBy = "aluno")
    private PlanoAluno planoAluno;

    public Aluno(Usuario usuario) {
        this.usuario = usuario;
    }
}
