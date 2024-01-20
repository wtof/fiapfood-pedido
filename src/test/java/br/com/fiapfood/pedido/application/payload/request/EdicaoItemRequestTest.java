package br.com.fiapfood.pedido.application.payload.request;

import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EdicaoItemRequestTest {

    @Test
    void testCategoriaId() {
        StatusDTO status = StatusDTO.DISPONIVEL;
        EdicaoItemRequest edicaoItemRequest = new EdicaoItemRequest(1, "Teste", 10.0F, 5, status);
        Integer expected = 1;
        assertEquals(expected, edicaoItemRequest.getCategoriaId());
    }

    @Test
    void testId() {
        StatusDTO status = StatusDTO.DISPONIVEL;
        EdicaoItemRequest edicaoItemRequest = new EdicaoItemRequest(1, "Teste", 10.0F, 5, status);
        Long expected = 1L;
        edicaoItemRequest.setId(expected);
        assertEquals(expected, edicaoItemRequest.getId());
    }
}