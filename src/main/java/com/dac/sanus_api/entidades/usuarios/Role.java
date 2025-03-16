package com.dac.sanus_api.entidades.usuarios;


import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ROLE")
@Data
@NoArgsConstructor
public class Role implements GrantedAuthority {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    public Role(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String getAuthority() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
