package br.com.fiapfood.pedido.application.services;

import br.com.fiapfood.pedido.application.payload.dto.StatusPedidoDTO;
import br.com.fiapfood.pedido.application.payload.request.EdicaoPedidoRequest;
import br.com.fiapfood.pedido.application.payload.request.PedidoRequest;
import br.com.fiapfood.pedido.domain.entities.Pedido;
import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import br.com.fiapfood.pedido.domain.interfaces.PedidoUseCase;
import br.com.fiapfood.pedido.domain.repository.ClienteRepository;
import br.com.fiapfood.pedido.domain.repository.ComboRepository;
import br.com.fiapfood.pedido.domain.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PedidoServiceImplTest {

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private ComboRepository comboRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private PedidoUseCase pedidoUseCase;

    private PedidoServiceImpl pedidoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pedidoService = new PedidoServiceImpl(itemRepository, clienteRepository, comboRepository, pedidoUseCase);
    }

    @Test
    void testEfetuarCheckout() {
        PedidoRequest pedidoRequest = new PedidoRequest();
        Pedido pedido = new Pedido();
        when(pedidoUseCase.salvarPedido(any())).thenReturn(pedido);
        pedidoService.efetuarCheckout(pedidoRequest);
        verify(pedidoUseCase).salvarPedido(any());
    }

    @Test
    void testBuscarPedido() {
        Long idPedido = 1L;
        Pedido pedido = new Pedido();
        when(pedidoUseCase.buscarPedido(any())).thenReturn(pedido);
        pedidoService.buscarPedido(idPedido);
        verify(pedidoUseCase).buscarPedido(idPedido);
    }

    @Test
    void testBuscarPedidoPorStatus() {
        StatusPedidoDTO status = StatusPedidoDTO.FINALIZADO;
        pedidoService.buscarPedidoPorStatus(status);
        verify(pedidoUseCase).buscarPedidoPorStatus(StatusPedido.valueOf(status.name()));
    }

    @Test
    void testAtualizarPedido() {
        EdicaoPedidoRequest edicaoPedidoRequest = new EdicaoPedidoRequest();
        edicaoPedidoRequest.setStatus(StatusPedidoDTO.EM_PREPARACAO);
        Pedido pedido = new Pedido();
        when(pedidoUseCase.atualizarPedido(any())).thenReturn(pedido);
        pedidoService.atualizarPedido(edicaoPedidoRequest);
        verify(pedidoUseCase).atualizarPedido(any());
    }

    @Test
    void testIniciarPedido() {
        Pedido pedido = new Pedido();
        when(pedidoUseCase.iniciarPedido()).thenReturn(pedido);
        pedidoService.iniciarPedido();
        verify(pedidoUseCase).iniciarPedido();
    }

    @Test
    void testBuscarPedidosAtivos() {
        pedidoService.buscarPedidosAtivos();
        verify(pedidoUseCase).buscarPedidosAtivos();
    }

    @Test
    void testAtualizarStatusPedido() {
        EdicaoPedidoRequest edicaoPedidoRequest = new EdicaoPedidoRequest();
        edicaoPedidoRequest.setStatus(StatusPedidoDTO.EM_PREPARACAO); // add this line
        Pedido pedido = new Pedido();
        when(pedidoUseCase.atualizarStatusPedido(any(), any())).thenReturn(pedido);
        pedidoService.atualizarStatusPedido(edicaoPedidoRequest);
        verify(pedidoUseCase).atualizarStatusPedido(any(), any());
    }
}