package br.com.fiapfood.pedido.application.payload.response;

import br.com.fiapfood.pedido.application.payload.dto.StatusPedidoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {

    private Long id;

    private StatusPedidoDTO status;

    private ClienteResponse cliente;

    private List<ItemResponse> itens;

    private List<ComboResponse> combos;
}
