package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.exceptions.ApplicationException;
import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import br.com.fiapfood.pedido.application.payload.response.ItemResponse;
import br.com.fiapfood.pedido.domain.entities.Categoria;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemResponseAdapterTest {

    @Test
    void adaptWithNullItemShouldThrowException() {
        ItemResponseAdapter adapter = ItemResponseAdapter.build();

        assertThrows(ApplicationException.class, () -> adapter.adapt((Item) null));
    }

    @Test
    void adaptWithValidItemShouldReturnItemResponse() {
        ItemResponseAdapter adapter = ItemResponseAdapter.build();
        Item item = new Item();
        item.setId(1L);
        item.setCategoria(new Categoria());
        item.setNome("Test");
        item.setPreco(10.0f);
        item.setQuantidadeEstoque(5);
        item.setStatus(StatusItem.DISPONIVEL);

        ItemResponse response = adapter.adapt(item);

        assertEquals(1L, response.getId());
        assertEquals("TEST", response.getNome());
        assertEquals(10.0f, response.getPreco());
        assertEquals(5, response.getQuantidadeEstoque());
        assertEquals(StatusDTO.DISPONIVEL, response.getStatus());
    }

    @Test
    void adaptWithValidListShouldReturnList() {
        ItemResponseAdapter adapter = ItemResponseAdapter.build();
        Item item = new Item();
        item.setId(1L);
        item.setCategoria(new Categoria());
        item.setNome("Test");
        item.setPreco(10.0f);
        item.setQuantidadeEstoque(5);
        item.setStatus(StatusItem.DISPONIVEL);

        List<ItemResponse> responses = adapter.adapt(Arrays.asList(item, item));

        assertEquals(2, responses.size());
        assertEquals(1L, responses.get(0).getId());
        assertEquals("TEST", responses.get(0).getNome());
        assertEquals(10.0f, responses.get(0).getPreco());
        assertEquals(5, responses.get(0).getQuantidadeEstoque());
        assertEquals(StatusDTO.DISPONIVEL, responses.get(0).getStatus());
        assertEquals(1L, responses.get(1).getId());
        assertEquals("TEST", responses.get(1).getNome());
        assertEquals(10.0f, responses.get(1).getPreco());
        assertEquals(5, responses.get(1).getQuantidadeEstoque());
        assertEquals(StatusDTO.DISPONIVEL, responses.get(1).getStatus());
    }
}