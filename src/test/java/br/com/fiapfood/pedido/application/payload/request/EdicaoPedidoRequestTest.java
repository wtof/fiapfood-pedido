package br.com.fiapfood.pedido.application.payload.request;

import br.com.fiapfood.pedido.application.payload.dto.ComboDTO;
import br.com.fiapfood.pedido.application.payload.dto.ItemDTO;
import br.com.fiapfood.pedido.application.payload.dto.StatusPedidoDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EdicaoPedidoRequestTest {

    @Test
    void testClienteId() {
        ItemDTO item = new ItemDTO();
        ComboDTO combo = new ComboDTO();
        EdicaoPedidoRequest edicaoPedidoRequest = new EdicaoPedidoRequest(1L, Arrays.asList(item), Arrays.asList(combo));
        Long expected = 1L;
        assertEquals(expected, edicaoPedidoRequest.getClienteId());
    }

    @Test
    void testId() {
        ItemDTO item = new ItemDTO();
        ComboDTO combo = new ComboDTO();
        EdicaoPedidoRequest edicaoPedidoRequest = new EdicaoPedidoRequest(1L, Arrays.asList(item), Arrays.asList(combo));
        Long expected = 1L;
        edicaoPedidoRequest.setId(expected);
        assertEquals(expected, edicaoPedidoRequest.getId());
    }

    @Test
    void testStatus() {
        ItemDTO item = new ItemDTO();
        ComboDTO combo = new ComboDTO();
        EdicaoPedidoRequest edicaoPedidoRequest = new EdicaoPedidoRequest(1L, Arrays.asList(item), Arrays.asList(combo));
        StatusPedidoDTO expected = StatusPedidoDTO.EM_PREPARACAO;
        edicaoPedidoRequest.setStatus(expected);
        assertEquals(expected, edicaoPedidoRequest.getStatus());
    }
}