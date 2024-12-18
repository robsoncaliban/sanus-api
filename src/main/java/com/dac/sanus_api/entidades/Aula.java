package com.dac.sanus_api.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import com.dac.sanus_api.entidades.enuns.AulaStatus;
import com.dac.sanus_api.entidades.enuns.Modalidade;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_AULA")
public class Aula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    //TODO: Fazer o enum na propria classe
    private Modalidade modalidade;
    @Temporal(TemporalType.DATE)
    private LocalDate dataAula;
    @Temporal(TemporalType.TIME)
    private LocalTime inicioAula;
    @Temporal(TemporalType.TIME)
    private LocalTime fimAula;
    @Enumerated(EnumType.STRING)
    private AulaStatus aulaStatus;

    @OneToMany(mappedBy = "aula")
    private Set<Ficha> fichas;

    @OneToMany(mappedBy = "aula")
    private List<AgendamentoAula> agendamentos;

    public Aula(Modalidade modalidade, LocalDate dataAula, LocalTime inicioAula, LocalTime fimAula) {
        this.modalidade = modalidade;
        this.dataAula = dataAula;
        this.inicioAula = inicioAula;
        this.fimAula = fimAula;
    }

}
