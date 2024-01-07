package br.com.fiapfood.pedido.domain.repository;

import br.com.fiapfood.pedido.domain.entities.Pedido;
import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import java.util.List;

public interface PedidoRepository {
    Pedido salvarPedido(Pedido pedido);

    Pedido atualizarPedido(Pedido pedido);

    Pedido buscarPedidoPorId(Long id);

    List<Pedido> buscarPedidoPorStatus(StatusPedido status);

    List<Pedido> buscarPedidosAtivos();
}
