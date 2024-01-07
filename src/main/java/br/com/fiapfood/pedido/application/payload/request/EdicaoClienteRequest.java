package br.com.fiapfood.pedido.application.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class EdicaoClienteRequest extends ClienteRequest {

    private Long idCliente;

    EdicaoClienteRequest(String nome, Long cpf) {
        super(nome, cpf);
    }
}
