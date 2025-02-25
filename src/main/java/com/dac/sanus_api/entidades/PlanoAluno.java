package com.dac.sanus_api.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.dac.sanus_api.entidades.enuns.PlanoStatus;
import com.dac.sanus_api.entidades.usuarios.Aluno;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_PLANO_ALUNO")
public class PlanoAluno implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name = "plano_id", nullable = false)
    private Plano plano;
    
    @ToString.Exclude
    @OneToMany(mappedBy = "planoAluno")
    @Setter(AccessLevel.NONE)
    private List<Pagamento> pagamentos;
    
    @ToString.Exclude
    @OneToMany(mappedBy = "planoAluno")
    private List<AgendamentoAula> agendamentos;
    
    @Temporal(TemporalType.DATE)
    private LocalDate dataAssinatura;
    
    @Enumerated(EnumType.STRING)
    private PlanoStatus status;
    
    public PlanoAluno(Aluno aluno, Plano plano) {
        this.aluno = aluno;
        this.plano = plano;
        this.status = PlanoStatus.BLOQUEADO;
        this.dataAssinatura = LocalDate.now();
        this.pagamentos = new ArrayList<>();
        this.agendamentos = new ArrayList<>();
    }

    public LocalDate getDataVencimento(){
        var duracaoMesses = getPlano().getDuracaoMesses();
        return getDataAssinatura().plusMonths(duracaoMesses);
    }

    public void addPagamento(Pagamento pagamento){
        pagamentos.add(pagamento);
    }

    public String getNomePlano(){
        return plano.getNome();
    }

}
