package com.example.app.negocio.dominio;

import com.example.app.apresentacao.ClienteModel;
import com.example.app.negocio.excecao.NomeMenorCincoCaracteresException;
import com.example.app.negocio.excecao.ClienteNaoDefinidoException;
import com.example.app.negocio.validador.FabricaValidadorTelefone;
import com.example.app.persistencia.Cliente;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClienteDTO {
    
    private long id;

    @EqualsAndHashCode.Include
    private String nome;
    private int idade;
    private String telefone;
    private double limiteCredito;
    private PaisDTO pais;

      public static ClienteDTO DTOFromEntity(Cliente cliente) {
        return ClienteDTO.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .telefone(cliente.getTelefone())
                .limiteCredito(cliente.getLimiteCredito())
                .build();
    }
    
    public static Set<ClienteDTO> DTOsFromEntities(List<Cliente> clientes) {
        var resultado = new HashSet<ClienteDTO>();

        for (Cliente clienteAtual : clientes) 
            resultado.add(ClienteDTO.DTOFromEntity(clienteAtual));

        return resultado;
    }
    
    public static Cliente EntityFromDTO (ClienteDTO cliente) {
        return Cliente.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .telefone(cliente.getTelefone())
                .limiteCredito(cliente.getLimiteCredito())
                .build();
    }
    
    public static Set<ClienteModel> ModelsFromDTOs (Set<ClienteDTO> clientes) {
        var resultado = new HashSet<ClienteModel>();
        
        for (ClienteDTO clienteAtual: clientes)
            resultado.add(ClienteDTO.ModelFromDTO(clienteAtual));
        
        return resultado;
    }
    
    public static ClienteModel ModelFromDTO (ClienteDTO cliente) {
        return ClienteModel.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .telefone(cliente.getTelefone())
                .limiteCredito(cliente.getLimiteCredito())
                .build();
    }
    
    public static ClienteDTO DTOFromModel (ClienteModel cliente) {
        return ClienteDTO.builder()
                 .id(cliente.getId())
                .nome(cliente.getNome())
                .telefone(cliente.getTelefone())
                .limiteCredito(cliente.getLimiteCredito())
                .build();
    } 
}
