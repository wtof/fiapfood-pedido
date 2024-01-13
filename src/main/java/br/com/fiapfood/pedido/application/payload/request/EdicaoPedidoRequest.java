package br.com.fiapfood.pedido.application.payload.request;


import br.com.fiapfood.pedido.application.payload.dto.ComboDTO;
import br.com.fiapfood.pedido.application.payload.dto.ItemDTO;
import br.com.fiapfood.pedido.application.payload.dto.StatusPedidoDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class EdicaoPedidoRequest extends PedidoRequest {

    public EdicaoPedidoRequest(Long clienteId, List<ItemDTO> itens, List<ComboDTO> combos) {
        super(clienteId, itens, combos);
    }

    private Long id;

    private StatusPedidoDTO status;

    public void setStatus(StatusPedidoDTO status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
