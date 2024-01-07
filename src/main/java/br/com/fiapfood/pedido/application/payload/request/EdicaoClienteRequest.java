package br.com.fiapfood.pedido.application.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class EdicaoClienteRequest extends ClienteRequest {
    private Long idCliente;

    EdicaoClienteRequest(String nome, Long cpf) {
        super(nome, cpf);
    }

    public void setIdCliente(final Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdCliente() {
        return this.idCliente;
    }
}
