package com.pw.leiloeiro.api.Infra.Exception;

public class NotFound extends RuntimeException {
    public NotFound(String mensagem) {
        super(mensagem);
    }

}