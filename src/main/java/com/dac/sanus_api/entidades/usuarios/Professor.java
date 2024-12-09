package com.dac.sanus_api.entidades.usuarios;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.dac.sanus_api.entidades.Aviso;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_PROFESSOR")
public class Professor implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private UUID id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @Column(unique = true)
    private String cref;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "autor")
    private List<Aviso> avisos;

    public Professor(Usuario usuario, String cref) {
        this.usuario = usuario;
        this.cref = cref;
    }
}
