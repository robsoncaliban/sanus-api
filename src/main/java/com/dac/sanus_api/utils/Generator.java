package com.dac.sanus_api.utils;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class Generator {

    public String gerarMatricula(String ultimaMatricula){
        int ano = LocalDate.now().getYear();
        String formato = "%d%04d";
        if(ultimaMatricula == null){
            return String.format(formato, ano, 1);
        }
        int sequencia = Integer.parseInt(ultimaMatricula.substring(4));
        return String.format(formato, ano, ++sequencia);
    }

    public String gerarSenhaAleatoria(int sizeSenha){
        SecureRandom random =  new SecureRandom();
        byte[] bytesAleatorios = new byte[sizeSenha];
        random.nextBytes(bytesAleatorios);
        String senhaBase64 = Base64.getEncoder().encodeToString(bytesAleatorios);
        return senhaBase64.substring(0, sizeSenha);
    }
}
