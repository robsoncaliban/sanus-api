package com.dac.sanus_api.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.dac.sanus_api.entidades.usuarios.Aluno;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_PAGAMENTO")
public class Pagamento implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataHoraPagamento;
    private BigDecimal valorPagamento;

    @ManyToOne
    @JoinColumn(name = "plano_aluno_id")
    private PlanoAluno planoAluno;
    
    public Pagamento(LocalDateTime dataHoraPagamento, BigDecimal valorPagamento) {
        this.dataHoraPagamento = dataHoraPagamento;
        this.valorPagamento = valorPagamento;
    }

    
}
