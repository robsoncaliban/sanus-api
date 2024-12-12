package com.dac.sanus_api.entidades;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_EXERCICIO")
public class Exercicio implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID id;
    private String name;
    private String descricao;
    private String videoExplicacao;

    public Exercicio(String name) {
        this.name = name;
    }

}
