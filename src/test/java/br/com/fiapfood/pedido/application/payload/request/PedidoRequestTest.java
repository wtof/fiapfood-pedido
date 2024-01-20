package br.com.fiapfood.pedido.application.payload.request;

import br.com.fiapfood.pedido.application.payload.dto.ComboDTO;
import br.com.fiapfood.pedido.application.payload.dto.ItemDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PedidoRequestTest {

    @Test
    void testClienteId() {
        PedidoRequest pedidoRequest = new PedidoRequest();
        Long expected = 1L;
        pedidoRequest.setClienteId(expected);
        assertEquals(expected, pedidoRequest.getClienteId());
    }

    @Test
    void testItens() {
        PedidoRequest pedidoRequest = new PedidoRequest();
        ItemDTO item = new ItemDTO();
        List<ItemDTO> expected = Arrays.asList(item);
        pedidoRequest.setItens(expected);
        assertEquals(expected, pedidoRequest.getItens());
    }

    @Test
    void testCombos() {
        PedidoRequest pedidoRequest = new PedidoRequest();
        ComboDTO combo = new ComboDTO();
        List<ComboDTO> expected = Arrays.asList(combo);
        pedidoRequest.setCombos(expected);
        assertEquals(expected, pedidoRequest.getCombos());
    }
}