package br.com.fiapfood.pedido.application.payload.request;

import br.com.fiapfood.pedido.application.payload.dto.ItemComboDTO;
import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ComboRequest {

    private String nome;

    private Float preco;

    private StatusDTO status;

    private List<ItemComboDTO> itens;
}
