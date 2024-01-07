package br.com.fiapfood.pedido.application.payload.request;

import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class EdicaoItemRequest extends ItemRequest {
    private Long id;

    EdicaoItemRequest(Integer categoriaId, String nome, Float preco, Integer quantidadeEstoque, StatusDTO status) {
        super(categoriaId, nome, preco, quantidadeEstoque, status);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
