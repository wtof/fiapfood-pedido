package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.exceptions.ApplicationException;
import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import br.com.fiapfood.pedido.application.payload.request.ItemRequest;
import br.com.fiapfood.pedido.domain.entities.Categoria;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.domain.repository.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ItemAdapterTest {

    @Test
    void adaptWithNullItemRequestShouldThrowException() {
        CategoriaRepository mockRepository = Mockito.mock(CategoriaRepository.class);
        ItemAdapter adapter = ItemAdapter.build(mockRepository);
        assertThrows(ApplicationException.class, () -> adapter.adapt((ItemRequest) null));
    }

    @Test
    void adaptWithValidItemRequestShouldReturnItem() {
        CategoriaRepository mockRepository = Mockito.mock(CategoriaRepository.class);
        when(mockRepository.buscarCategoriaPorId(1)).thenReturn(new Categoria());

        ItemAdapter adapter = ItemAdapter.build(mockRepository);
        ItemRequest request = new ItemRequest();
        request.setCategoriaId(1);
        request.setNome("Test");
        request.setPreco(10.0f);
        request.setQuantidadeEstoque(5);
        request.setStatus(StatusDTO.DISPONIVEL);

        Item item = adapter.adapt(request);

        assertEquals("Test", item.getNome());
        assertEquals(10.0f, item.getPreco());
        assertEquals(5, item.getQuantidadeEstoque());
        assertEquals(StatusItem.DISPONIVEL, item.getStatus());
    }

    @Test
    void adaptWithNullListShouldThrowException() {
        CategoriaRepository mockRepository = Mockito.mock(CategoriaRepository.class);
        ItemAdapter adapter = ItemAdapter.build(mockRepository);
        assertThrows(ApplicationException.class, () -> adapter.adapt((List<ItemRequest>) null));
    }

    @Test
    void adaptWithEmptyListShouldThrowException() {
        CategoriaRepository mockRepository = Mockito.mock(CategoriaRepository.class);
        ItemAdapter adapter = ItemAdapter.build(mockRepository);
        assertThrows(ApplicationException.class, () -> adapter.adapt(Arrays.asList()));
    }

    @Test
    void adaptWithValidListShouldReturnList() {
        CategoriaRepository mockRepository = Mockito.mock(CategoriaRepository.class);
        when(mockRepository.buscarCategoriaPorId(1)).thenReturn(new Categoria());

        ItemAdapter adapter = ItemAdapter.build(mockRepository);
        ItemRequest request = new ItemRequest();
        request.setCategoriaId(1);
        request.setNome("Test");
        request.setPreco(10.0f);
        request.setQuantidadeEstoque(5);
        request.setStatus(StatusDTO.DISPONIVEL);

        List<Item> items = adapter.adapt(Arrays.asList(request, request));

        assertEquals(2, items.size());
        assertEquals("Test", items.get(0).getNome());
        assertEquals(10.0f, items.get(0).getPreco());
        assertEquals(5, items.get(0).getQuantidadeEstoque());
        assertEquals(StatusItem.DISPONIVEL, items.get(0).getStatus());
        assertEquals("Test", items.get(1).getNome());
        assertEquals(10.0f, items.get(1).getPreco());
        assertEquals(5, items.get(1).getQuantidadeEstoque());
        assertEquals(StatusItem.DISPONIVEL, items.get(1).getStatus());
    }
}