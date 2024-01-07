package br.com.fiapfood.pedido.application.payload.request;

import br.com.fiapfood.pedido.application.payload.dto.ComboDTO;
import br.com.fiapfood.pedido.application.payload.dto.ItemDTO;
import java.util.List;

public class EdicaoPedidoRequest extends PedidoRequest {
    private Long id;

    public EdicaoPedidoRequest(Long clienteId, List<ItemDTO> itens, List<ComboDTO> combos) {
        super(clienteId, itens, combos);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
