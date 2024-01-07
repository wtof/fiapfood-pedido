package br.com.fiapfood.pedido.application.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriaResponse {

    private Integer id;

    private String nome;

    private String descricao;
}