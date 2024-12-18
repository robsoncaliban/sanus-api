package com.dac.sanus_api.entidades.usuarios;

import java.io.Serializable;
import com.dac.sanus_api.dtos.UsuarioRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable{
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
    private String email;
    
    private String senha;
    
    private String telefone;
    
    @EqualsAndHashCode.Include
    private String cpf;

    @ToString.Include
    private boolean ativo;

    public Usuario(UsuarioRequestDTO usuarioDto) {
        this.ativo = true;
        this.nome = usuarioDto.nome();
        this.email = usuarioDto.email();
        this.senha = usuarioDto.senha();
        this.telefone = usuarioDto.telefone();
        this.cpf = usuarioDto.cpf();
    }

    
}
