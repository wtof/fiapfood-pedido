package br.com.fiapfood.pedido.application.payload.response;

import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ComboResponse {

    private Long id;

    private String nome;

    private Float preco;

    private StatusDTO status;

    private List<ItemResponse> itens;
}