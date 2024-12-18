package com.dac.sanus_api.entidades.usuarios;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.dac.sanus_api.entidades.AgendamentoAula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
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
    // TODO: matricula vai ser gerada automaticamente?
    @Column(unique = true)
    private String matricula;

    @OneToMany(mappedBy = "aluno")
    private List<AgendamentoAula> agendamentos;

    public Aluno(Usuario usuario, String matricula) {
        this.usuario = usuario;
        this.matricula = matricula;
    }
}
