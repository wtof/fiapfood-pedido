package br.com.fiapfood.pedido.application.payload.request;

import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemRequestTest {

    @Test
    void testCategoriaId() {
        ItemRequest itemRequest = new ItemRequest();
        Integer expected = 1;
        itemRequest.setCategoriaId(expected);
        assertEquals(expected, itemRequest.getCategoriaId());
    }

    @Test
    void testNome() {
        ItemRequest itemRequest = new ItemRequest();
        String expected = "Teste";
        itemRequest.setNome(expected);
        assertEquals(expected, itemRequest.getNome());
    }

    @Test
    void testPreco() {
        ItemRequest itemRequest = new ItemRequest();
        Float expected = 10.0F;
        itemRequest.setPreco(expected);
        assertEquals(expected, itemRequest.getPreco());
    }

    @Test
    void testQuantidadeEstoque() {
        ItemRequest itemRequest = new ItemRequest();
        Integer expected = 5;
        itemRequest.setQuantidadeEstoque(expected);
        assertEquals(expected, itemRequest.getQuantidadeEstoque());
    }

    @Test
    void testStatus() {
        ItemRequest itemRequest = new ItemRequest();
        StatusDTO expected = StatusDTO.DISPONIVEL;
        itemRequest.setStatus(expected);
        assertEquals(expected, itemRequest.getStatus());
    }
}