package com.dac.sanus_api.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.dac.sanus_api.entidades.usuarios.Aluno;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_AGENDAMENTO_AULA")
public class AgendamentoAula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;
    private LocalDateTime dataHoraAgendado;
    private AgendamentoStatus statusAgendamento;
    private boolean visivel;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Aula aula;

    public AgendamentoAula(LocalDateTime dataHoraAgendado, AgendamentoStatus statusAgendamento, boolean visivel,
            Aluno aluno, Aula aula) {
        this.dataHoraAgendado = dataHoraAgendado;
        this.statusAgendamento = statusAgendamento;
        this.visivel = visivel;
        this.aluno = aluno;
        this.aula = aula;
    }

}
