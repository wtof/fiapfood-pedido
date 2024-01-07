package br.com.fiapfood.pedido.application.payload.request;

import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemRequest {

    private Integer categoriaId;

    private String nome;

    private Float preco;

    private Integer quantidadeEstoque;

    private StatusDTO status;
}
