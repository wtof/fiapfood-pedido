package br.com.fiapfood.pedido.infra.controller;

import br.com.fiapfood.pedido.application.interfaces.PedidoService;
import br.com.fiapfood.pedido.application.payload.dto.StatusPedidoDTO;
import br.com.fiapfood.pedido.application.payload.request.EdicaoPedidoRequest;
import br.com.fiapfood.pedido.application.payload.request.PedidoRequest;
import br.com.fiapfood.pedido.application.payload.response.PedidoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PedidoControllerTest {

    @InjectMocks
    private PedidoController pedidoController;

    @Mock
    private PedidoService pedidoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCheckoutPedido() {
        PedidoResponse pedido = new PedidoResponse();

        when(pedidoService.efetuarCheckout(any())).thenReturn(pedido);

        ResponseEntity<PedidoResponse> response = pedidoController.checkoutPedido(new PedidoRequest());
        assertEquals(pedido, response.getBody());
    }

    @Test
    void testBuscarPedido() {
        PedidoResponse pedido = new PedidoResponse();
        when(pedidoService.buscarPedido(anyLong())).thenReturn(pedido);

        ResponseEntity<PedidoResponse> response = pedidoController.buscarPedido(1L);
        assertEquals(pedido, response.getBody());
    }

    @Test
    void testAtualizarPedido() {
        PedidoResponse pedido = new PedidoResponse();

        when(pedidoService.atualizarPedido(any())).thenReturn(pedido);

        ResponseEntity<PedidoResponse> response = pedidoController.atualizarPedido(new EdicaoPedidoRequest());
        assertEquals(pedido, response.getBody());
    }

    @Test
    void testAtualizarStatusPedido() {
        PedidoResponse pedido = new PedidoResponse();

        when(pedidoService.atualizarStatusPedido(any())).thenReturn(pedido);

        ResponseEntity<PedidoResponse> response = pedidoController.atualizarStatusPedido(new EdicaoPedidoRequest());
        assertEquals(pedido, response.getBody());
    }

    @Test
    void testBuscarPedidoPorStatus() {
        PedidoResponse pedido1 = new PedidoResponse();
        PedidoResponse pedido2 = new PedidoResponse();

        when(pedidoService.buscarPedidoPorStatus(any())).thenReturn(Arrays.asList(pedido1, pedido2));

        ResponseEntity<List<PedidoResponse>> response = pedidoController.buscarPedido(StatusPedidoDTO.INICIADO);
        assertEquals(2, response.getBody().size());
    }

    @Test
    void testBuscarPedidosAtivos() {
        PedidoResponse pedido1 = new PedidoResponse();
        PedidoResponse pedido2 = new PedidoResponse();

        when(pedidoService.buscarPedidosAtivos()).thenReturn(Arrays.asList(pedido1, pedido2));

        ResponseEntity<List<PedidoResponse>> response = pedidoController.buscarPedidosAtivos();
        assertEquals(2, response.getBody().size());
    }
}