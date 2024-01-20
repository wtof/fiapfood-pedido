package br.com.fiapfood.pedido.application.payload.response;

import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import br.com.fiapfood.pedido.domain.entities.Categoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemResponseTest {

    @Test
    void testId() {
        ItemResponse itemResponse = ItemResponse.builder().id(1L).build();
        Long expected = 1L;
        assertEquals(expected, itemResponse.getId());
    }

    @Test
    void testNome() {
        ItemResponse itemResponse = ItemResponse.builder().nome("Teste").build();
        String expected = "Teste";
        assertEquals(expected, itemResponse.getNome());
    }

    @Test
    void testPreco() {
        ItemResponse itemResponse = ItemResponse.builder().preco(10.0F).build();
        Float expected = 10.0F;
        assertEquals(expected, itemResponse.getPreco());
    }

    @Test
    void testQuantidadeEstoque() {
        ItemResponse itemResponse = ItemResponse.builder().quantidadeEstoque(5).build();
        Integer expected = 5;
        assertEquals(expected, itemResponse.getQuantidadeEstoque());
    }

    @Test
    void testStatus() {
        StatusDTO status =  StatusDTO.DISPONIVEL;
        ItemResponse itemResponse = ItemResponse.builder().status(status).build();
        assertEquals(status, itemResponse.getStatus());
    }

    @Test
    void testCategoria() {
        Categoria categoria = new Categoria();
        ItemResponse itemResponse = ItemResponse.builder().categoria(categoria).build();
        assertEquals(categoria, itemResponse.getCategoria());
    }
}