package br.com.fiapfood.pedido.application.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponse {

    private Integer id;

    private String nome;

    private String descricao;
}