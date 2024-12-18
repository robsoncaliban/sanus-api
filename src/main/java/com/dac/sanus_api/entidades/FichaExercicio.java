package com.dac.sanus_api.entidades;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_FICHA_EXERCICIO")
public class FichaExercicio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private int tempoSegundos;
    private int repeticoes;

    @ManyToOne
    @JoinColumn(name = "exercicio_id")
    private Exercicio exercicio;
    @ManyToOne
    @JoinColumn(name = "ficha_id")
    private Ficha ficha;

    public FichaExercicio(int tempoSegundos, int repeticoes, Exercicio exercicio, Ficha ficha) {
        this.tempoSegundos = tempoSegundos;
        this.repeticoes = repeticoes;
        this.exercicio = exercicio;
        this.ficha = ficha;
    }
    
}
