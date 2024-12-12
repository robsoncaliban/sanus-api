package com.dac.sanus_api.entidades;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_CONFIGURACAO_EXERCICIO")
public class ConfiguracaoExercicio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;
    private int tempoSegundos;
    private int repeticoes;

    @ManyToOne
    private Exercicio exercicio;
}
