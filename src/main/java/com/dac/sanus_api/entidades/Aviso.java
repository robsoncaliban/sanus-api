package com.dac.sanus_api.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import com.dac.sanus_api.entidades.usuarios.Professor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "TB_AVISO")
public class Aviso implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Temporal(TemporalType.TIMESTAMP)
    private Instant dataHoraPublicacao;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String descricao;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTOR_FK")
    private Professor autor;
    private int curtidas;
    private boolean fixado;
    
    public Aviso(Instant dataHoraPublicacao, String titulo, String descricao, boolean fixado) {
        this.dataHoraPublicacao = dataHoraPublicacao;
        this.titulo = titulo;
        this.descricao = descricao;
        this.fixado = fixado;
        this.curtidas = 0;
    }

    public boolean isFixado() {
        return this.fixado;
    }
}
