package br.com.fiapfood.pedido.application.payload.response;

import br.com.fiapfood.pedido.application.payload.dto.StatusPedidoDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PedidoResponseTest {

    @Test
    void testId() {
        PedidoResponse pedidoResponse = PedidoResponse.builder().id(1L).build();
        Long expected = 1L;
        assertEquals(expected, pedidoResponse.getId());
    }

    @Test
    void testStatus() {
        StatusPedidoDTO status = StatusPedidoDTO.PAGO;
        PedidoResponse pedidoResponse = PedidoResponse.builder().status(status).build();
        assertEquals(status, pedidoResponse.getStatus());
    }

    @Test
    void testCliente() {
        ClienteResponse cliente = new ClienteResponse();
        PedidoResponse pedidoResponse = PedidoResponse.builder().cliente(cliente).build();
        assertEquals(cliente, pedidoResponse.getCliente());
    }

    @Test
    void testItens() {
        ItemResponse item = new ItemResponse();
        List<ItemResponse> expected = Arrays.asList(item);
        PedidoResponse pedidoResponse = PedidoResponse.builder().itens(expected).build();
        assertEquals(expected, pedidoResponse.getItens());
    }

    @Test
    void testCombos() {
        ComboResponse combo = new ComboResponse(); // You may need to set some properties here
        List<ComboResponse> expected = Arrays.asList(combo);
        PedidoResponse pedidoResponse = PedidoResponse.builder().combos(expected).build();
        assertEquals(expected, pedidoResponse.getCombos());
    }
}