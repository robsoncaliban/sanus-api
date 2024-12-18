package com.dac.sanus_api.entidades;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_EXERCICIO")
public class Exercicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String descricao;
    private String linkVideoExplicacao;

    @OneToMany(mappedBy = "exercicio")
    private List<FichaExercicio> fichasExercicio;

    public Exercicio(String name, String descricao, String videoExplicacao, List<FichaExercicio> fichasExercicio) {
        this.name = name;
        this.descricao = descricao;
        this.linkVideoExplicacao = videoExplicacao;
        this.fichasExercicio = fichasExercicio;
    }



}
