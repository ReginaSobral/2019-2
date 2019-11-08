package com.example.app.apresentacao;

import com.example.app.persistencia.Pais;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteModel {
    
    private Long id;
    private String nome;
    private int idade;
    private double limiteCredito;
    private String telefone;
    private Pais pais;
}
