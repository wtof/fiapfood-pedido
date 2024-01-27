package br.com.fiapfood.pedido.application.services;

import br.com.fiapfood.pedido.application.interfaces.PedidoService;
import br.com.fiapfood.pedido.application.payload.adapter.PedidoAdapter;
import br.com.fiapfood.pedido.application.payload.adapter.PedidoResponseAdapter;
import br.com.fiapfood.pedido.application.payload.dto.StatusPedidoDTO;
import br.com.fiapfood.pedido.application.payload.request.EdicaoPedidoRequest;
import br.com.fiapfood.pedido.application.payload.request.PedidoRequest;
import br.com.fiapfood.pedido.application.payload.response.PedidoResponse;
import br.com.fiapfood.pedido.domain.entities.Pedido;
import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import br.com.fiapfood.pedido.domain.interfaces.PedidoUseCase;
import br.com.fiapfood.pedido.domain.repository.ClienteRepository;
import br.com.fiapfood.pedido.domain.repository.ComboRepository;
import br.com.fiapfood.pedido.domain.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {
    private final ItemRepository itemRepository;
    private final ComboRepository comboRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoUseCase pedidoUseCase;

    public PedidoServiceImpl(ItemRepository itemRepository, ClienteRepository clienteRepository, ComboRepository comboRepository, PedidoUseCase pedidoUseCase) {
        this.itemRepository = itemRepository;
        this.comboRepository = comboRepository;
        this.clienteRepository = clienteRepository;
        this.pedidoUseCase = pedidoUseCase;
    }

    public PedidoResponse efetuarCheckout(PedidoRequest pedidoRequest) {
        Pedido pedido = PedidoAdapter.build(this.itemRepository, this.comboRepository, this.clienteRepository).adapt(pedidoRequest);
        return PedidoResponseAdapter.build().convert(this.pedidoUseCase.salvarPedido(pedido));
    }

    public PedidoResponse buscarPedido(Long idPedido) {
        return PedidoResponseAdapter.build().convert(this.pedidoUseCase.buscarPedido(idPedido));
    }

    public List<PedidoResponse> buscarPedidoPorStatus(StatusPedidoDTO status) {
        StatusPedido statusPedido = StatusPedido.valueOf(status.name());
        return PedidoResponseAdapter.build().convert(this.pedidoUseCase.buscarPedidoPorStatus(statusPedido));
    }

    public PedidoResponse atualizarPedido(EdicaoPedidoRequest edicaoPedidoRequest) {
        Pedido pedido = PedidoAdapter.build(this.itemRepository, this.comboRepository, this.clienteRepository).adapt(edicaoPedidoRequest);
        return PedidoResponseAdapter.build().convert(this.pedidoUseCase.atualizarPedido(pedido));
    }
    public PedidoResponse iniciarPedido() {
        return PedidoResponseAdapter.build().convert(this.pedidoUseCase.iniciarPedido());
    }

    public List<PedidoResponse> buscarPedidosAtivos() {
        return PedidoResponseAdapter.build().convert(this.pedidoUseCase.buscarPedidosAtivos());
    }

    @Override
    public PedidoResponse atualizarStatusPedido(EdicaoPedidoRequest edicaoPedidoRequest) {
        Long id = edicaoPedidoRequest.getId();
        StatusPedidoDTO status = edicaoPedidoRequest.getStatus();
        StatusPedido statusPedido = StatusPedido.valueOf(status.name());

        return PedidoResponseAdapter.build()
                .convert(pedidoUseCase.atualizarStatusPedido(id, statusPedido));
    }
}
