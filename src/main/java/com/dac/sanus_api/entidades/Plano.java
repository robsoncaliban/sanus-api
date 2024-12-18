package com.dac.sanus_api.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TB_PLANO")
@Data
public class Plano implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "plano")
    private List<PlanoAluno> planosAluno;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descricao;
    private int diasSemanaisDisponiveis;
    private int duracaoMeses;
    @Column(nullable = false)
    private BigDecimal valor;
    private int congelamentoDias;

    public Plano(String nome, String descricao, BigDecimal valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }
}
