package br.com.fiapfood.pedido.application.payload.request;

import br.com.fiapfood.pedido.application.payload.dto.ItemComboDTO;
import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComboRequest {

    private String nome;

    private Float preco;

    private StatusDTO status;

    private List<ItemComboDTO> itens;
}
