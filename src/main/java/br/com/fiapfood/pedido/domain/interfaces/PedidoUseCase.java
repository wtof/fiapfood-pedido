package br.com.fiapfood.pedido.domain.interfaces;

import br.com.fiapfood.pedido.domain.entities.Pedido;
import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import java.util.List;

public interface PedidoUseCase {
    Pedido salvarPedido(Pedido pedido);

    Pedido buscarPedido(Long idPedido);

    List<Pedido> buscarPedidoPorStatus(StatusPedido status);

    Pedido atualizarPedido(Pedido pedido);

    Pedido iniciarPedido();

    List<Pedido> buscarPedidosAtivos();

    Pedido atualizarStatusPedido(Long idPedido, StatusPedido statusPedido);

    void enviarPedidoProducao(Pedido pedido);
}
