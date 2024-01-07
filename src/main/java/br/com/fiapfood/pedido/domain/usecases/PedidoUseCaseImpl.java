package br.com.fiapfood.pedido.domain.usecases;

import br.com.fiapfood.pedido.domain.entities.Pedido;
import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import br.com.fiapfood.pedido.domain.interfaces.PedidoUseCase;
import br.com.fiapfood.pedido.domain.repository.PedidoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoUseCaseImpl implements PedidoUseCase {
    private final PedidoRepository pedidoRepository;

    public PedidoUseCaseImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido salvarPedido(Pedido pedido) {
        if (pedido.getItens() != null && !pedido.getItens().isEmpty() || pedido.getCombos() != null && !pedido.getCombos().isEmpty()) {
            pedido.setStatus(StatusPedido.INICIADO);
            return this.pedidoRepository.salvarPedido(pedido);
        } else {
            throw new DominioException("Não é possível efetuar o checkout de um pedido que não possui produtos");
        }
    }

    public Pedido buscarPedido(Long idPedido) {
        Pedido pedido = this.pedidoRepository.buscarPedidoPorId(idPedido);
        if (pedido == null) {
            throw new DominioException("Nenhum pedido foi encontrado com o id fornecido");
        } else {
            return pedido;
        }
    }

    public List<Pedido> buscarPedidoPorStatus(StatusPedido status) {
        List<Pedido> pedidos = this.pedidoRepository.buscarPedidoPorStatus(StatusPedido.valueOf(status.name()));
        return pedidos != null && !pedidos.isEmpty() ? pedidos : null;
    }

    public Pedido atualizarPedido(Pedido pedido) {
        Pedido pedidoBase = this.pedidoRepository.buscarPedidoPorId(pedido.getId());
        if (pedidoBase == null) {
            throw new DominioException("Nao foi possível atualizar o pedido, pedido nao encontrado na base dados");
        } else {
            return this.pedidoRepository.atualizarPedido(pedido);
        }
    }

    public Pedido iniciarPedido() {
        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.INICIADO);
        return this.pedidoRepository.atualizarPedido(pedido);
    }

    public List<Pedido> buscarPedidosAtivos() {
        return this.pedidoRepository.buscarPedidosAtivos();
    }
}
