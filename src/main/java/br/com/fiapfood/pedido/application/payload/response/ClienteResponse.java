package br.com.fiapfood.pedido.application.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteResponse {

    private Long id;
    private String nome;
    private Long cpf;
}
