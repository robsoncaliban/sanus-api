package com.dac.sanus_api.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_AULA")
public class Aula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;

    private Modalidade modalidade;
    private LocalDate dataAula;
    private LocalTime inicioAulaHora;
    private LocalTime finalAulaHora;
    private AulaStatus aulaStatus;

    @OneToMany(mappedBy = "aula")
    private Set<Ficha> fichas;

    @OneToMany(mappedBy = "aula")
    private List<AgendamentoAula> agendamentos;

    public Aula(Modalidade modalidade, LocalDate dataAula, LocalTime inicioAulaHora, LocalTime finalAulaHora) {
        this.modalidade = modalidade;
        this.dataAula = dataAula;
        this.inicioAulaHora = inicioAulaHora;
        this.finalAulaHora = finalAulaHora;
    }

}
