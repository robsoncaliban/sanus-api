package com.dac.sanus_api.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.dac.sanus_api.entidades.enuns.AgendamentoStatus;
import com.dac.sanus_api.entidades.usuarios.Aluno;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_AGENDAMENTO_AULA")
public class AgendamentoAula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataHoraAgendado;
    @Enumerated(EnumType.STRING)
    private AgendamentoStatus statusAgendamento;
    private boolean visivel;

    @ManyToOne
    @JoinColumn(name = "plano_aluno_id")
    private PlanoAluno planoAluno;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;

    public AgendamentoAula(LocalDateTime dataHoraAgendado, AgendamentoStatus statusAgendamento, boolean visivel,
            PlanoAluno planoAluno, Aula aula) {
        this.dataHoraAgendado = dataHoraAgendado;
        this.statusAgendamento = statusAgendamento;
        this.visivel = visivel;
        this.planoAluno = planoAluno;
        this.aula = aula;
    }

    public Aluno getAluno(){
        return planoAluno.getAluno();
    }

}
