package br.com.fiapfood.pedido.application.interfaces;

import br.com.fiapfood.pedido.application.payload.dto.StatusPedidoDTO;
import br.com.fiapfood.pedido.application.payload.request.EdicaoPedidoRequest;
import br.com.fiapfood.pedido.application.payload.request.PedidoRequest;
import br.com.fiapfood.pedido.application.payload.response.PedidoResponse;
import java.util.List;

public interface PedidoService {
    PedidoResponse buscarPedido(Long idPedido);

    List<PedidoResponse> buscarPedidoPorStatus(StatusPedidoDTO status);

    PedidoResponse atualizarPedido(EdicaoPedidoRequest edicaoPedidoRequest);

    PedidoResponse atualizarStatusPedido(EdicaoPedidoRequest edicaoPedidoRequest);

    PedidoResponse iniciarPedido();

    List<PedidoResponse> buscarPedidosAtivos();

    PedidoResponse efetuarCheckout(PedidoRequest pedidoRequest);
}
