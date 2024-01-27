package br.com.fiapfood.pedido.application.payload.response;

import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComboResponseTest {

    @Test
    void testId() {
        ComboResponse comboResponse = ComboResponse.builder().id(1L).build();
        Long expected = 1L;
        assertEquals(expected, comboResponse.getId());
    }

    @Test
    void testNome() {
        ComboResponse comboResponse = ComboResponse.builder().nome("Teste").build();
        String expected = "Teste";
        assertEquals(expected, comboResponse.getNome());
    }

    @Test
    void testPreco() {
        ComboResponse comboResponse = ComboResponse.builder().preco(10.0F).build();
        Float expected = 10.0F;
        assertEquals(expected, comboResponse.getPreco());
    }

    @Test
    void testStatus() {
        StatusDTO status = StatusDTO.DISPONIVEL;
        ComboResponse comboResponse = ComboResponse.builder().status(status).build();
        assertEquals(status, comboResponse.getStatus());
    }

    @Test
    void testItens() {
        ItemResponse item = new ItemResponse();
        List<ItemResponse> expected = Arrays.asList(item);
        ComboResponse comboResponse = ComboResponse.builder().itens(expected).build();
        assertEquals(expected, comboResponse.getItens());
    }
}