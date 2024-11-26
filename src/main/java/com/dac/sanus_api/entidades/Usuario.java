package com.dac.sanus_api.entidades;

import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ToString.Include
    private UUID id;
    
    @ToString.Include
    private boolean admin;
    
    @ToString.Include
    private String nome;
    
    @EqualsAndHashCode.Include
    private String email;
    
    private String senha;
    
    private String telefone;
    
    @EqualsAndHashCode.Include
    private String cpf;

    @ToString.Include
    private boolean ativo;

    public Usuario(String nome, String email, String senha, String telefone, String cpf) {
        this.ativo = true;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    
}
