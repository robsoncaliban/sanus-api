package com.dac.sanus_api.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import com.dac.sanus_api.entidades.enuns.PlanoStatus;
import com.dac.sanus_api.entidades.usuarios.Aluno;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_PLANO_ALUNO")
@Data
@NoArgsConstructor
public class PlanoAluno implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;

    @OneToMany(mappedBy = "planoAluno")
    private List<AgendamentoAula> agendamentos;

    @Temporal(TemporalType.DATE)
    private LocalDate dataAssinatura;
    private LocalDate dataVencimento;
    @Enumerated(EnumType.STRING)
    private PlanoStatus status;
    
    public PlanoAluno(Aluno aluno, Plano plano, LocalDate dataVencimento) {
        this.aluno = aluno;
        this.plano = plano;
        this.dataVencimento = dataVencimento;
    }

    

}
