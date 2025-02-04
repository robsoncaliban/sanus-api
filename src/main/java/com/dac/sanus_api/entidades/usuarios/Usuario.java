package com.dac.sanus_api.entidades.usuarios;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Long id;

    @ToString.Include
    private boolean admin;

    @ToString.Include
    private String nome;

    @EqualsAndHashCode.Include
    @Column(unique = true)
    private String email;

    @ToString.Include
    private String senha;

    @ToString.Include
    private String telefone;

    @EqualsAndHashCode.Include
    @Column(unique = true)
    private String cpf;

    @ToString.Include
    private boolean ativo;

}
