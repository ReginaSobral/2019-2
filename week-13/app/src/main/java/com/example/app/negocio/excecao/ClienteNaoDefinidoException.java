package com.example.app.negocio.excecao;

public class ClienteNaoDefinidoException extends Exception {

    public ClienteNaoDefinidoException() {
        super("Cliente não pode ser nulo/vazio");
    }
    
}
