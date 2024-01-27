package br.com.fiapfood.pedido.application.payload.request;

import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class EdicaoItemRequest extends ItemRequest {

    EdicaoItemRequest(Integer categoriaId, String nome, Float preco, Integer quantidadeEstoque, StatusDTO status) {
        super(categoriaId, nome, preco, quantidadeEstoque, status);
        // TODO Auto-generated constructor stub
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
