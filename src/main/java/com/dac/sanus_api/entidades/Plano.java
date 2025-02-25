package com.dac.sanus_api.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.dac.sanus_api.entidades.dtos.request.PlanoRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    private int duracaoMesses;
    
    @Column(nullable = false)
    private int diasSemanaisDisponiveis;
    
    @Column(nullable = false, scale = 2)
    private BigDecimal valor;
    
    @Column(nullable = false)
    private int congelamentoDias;
    
    public Plano(PlanoRequestDto planoDto) {
        this.nome = planoDto.nome();
        this.descricao = planoDto.descricao();
        this.duracaoMesses = planoDto.duracaoMesses();
        this.diasSemanaisDisponiveis = planoDto.diasSemanaisDisponiveis();
        this.valor = planoDto.valor().setScale(2, RoundingMode.HALF_UP);
        this.congelamentoDias = planoDto.congelamentoDias();
    }

    
}
