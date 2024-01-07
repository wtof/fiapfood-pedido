package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.exceptions.ApplicationException;
import br.com.fiapfood.pedido.application.payload.dto.StatusPedidoDTO;
import br.com.fiapfood.pedido.application.payload.response.PedidoResponse;
import br.com.fiapfood.pedido.domain.entities.Pedido;
import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PedidoResponseAdapter {
    private PedidoResponseAdapter() {
    }

    public static PedidoResponseAdapter build() {
        return new PedidoResponseAdapter();
    }

    public PedidoResponse convert(Pedido pedido) {
        if (pedido == null) {
            throw new ApplicationException("Não é possível converter um pedido nulo");
        } else {
            return PedidoResponse.builder().id(pedido.getId()).cliente(pedido.getCliente() != null ? ClienteResponseAdapter.build().adapt(pedido.getCliente()) : null).combos(!this.isPedidosComboNullOrEmpty(pedido) ? ComboResponseAdapter.build().adapt(pedido.getCombos()) : null).itens(!this.isItensNullOrEmpty(pedido) ? ItemResponseAdapter.build().adapt(pedido.getItens()) : null).status(this.convertStatus(pedido.getStatus())).build();
        }
    }

    public List<PedidoResponse> convert(List<Pedido> pedidos) {
        if (pedidos != null && !pedidos.isEmpty()) {
            List<PedidoResponse> pedidosResponse = new ArrayList();
            Iterator var3 = pedidos.iterator();

            while(var3.hasNext()) {
                Pedido pedido = (Pedido)var3.next();
                pedidosResponse.add(this.convert(pedido));
            }

            return pedidosResponse;
        } else {
            return new ArrayList();
        }
    }

    private boolean isPedidosComboNullOrEmpty(Pedido pedido) {
        return pedido.getCombos() == null || pedido.getCombos().isEmpty();
    }

    private boolean isItensNullOrEmpty(Pedido pedido) {
        return pedido.getItens() == null || pedido.getItens().isEmpty();
    }

    private StatusPedidoDTO convertStatus(StatusPedido statusPedido) {
        return statusPedido == null ? null : StatusPedidoDTO.valueOf(statusPedido.name());
    }
}
