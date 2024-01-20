package br.com.fiapfood.pedido.application.services;

import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import br.com.fiapfood.pedido.application.payload.request.EdicaoItemRequest;
import br.com.fiapfood.pedido.application.payload.request.ItemRequest;
import br.com.fiapfood.pedido.application.payload.response.ItemResponse;
import br.com.fiapfood.pedido.domain.entities.Categoria;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.interfaces.ItemUseCase;
import br.com.fiapfood.pedido.domain.repository.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @Mock
    private ItemUseCase itemUseCase;

    @InjectMocks
    private ItemServiceImpl itemService;

    @Test
    void testSalvarItemWithNonNullReturn() {
        ItemRequest itemRequest = new ItemRequest();
        itemRequest.setCategoriaId(1);
        itemRequest.setStatus(StatusDTO.DISPONIVEL);
        Item item = new Item();
        Categoria categoria = new Categoria();
        when(categoriaRepository.buscarCategoriaPorId(anyInt())).thenReturn(categoria);
        when(itemUseCase.salvarItem(any())).thenReturn(item);
        ItemResponse result = itemService.salvarItem(itemRequest);
        assertNotNull(result);
        verify(itemUseCase, times(1)).salvarItem(any());
    }

    @Test
    void testAtualizarItemWithNonNullReturn() {
        EdicaoItemRequest edicaoItemRequest = new EdicaoItemRequest();
        edicaoItemRequest.setId(1L); // Set a non-null ID
        edicaoItemRequest.setCategoriaId(1);
        edicaoItemRequest.setStatus(StatusDTO.DISPONIVEL);
        Item item = new Item();
        Categoria categoria = new Categoria();
        when(categoriaRepository.buscarCategoriaPorId(anyInt())).thenReturn(categoria);
        when(itemUseCase.atualizarItem(any(), anyLong())).thenReturn(item);
        ItemResponse result = itemService.atualizarItem(edicaoItemRequest);
        assertNotNull(result);
        verify(itemUseCase, times(1)).atualizarItem(any(), anyLong());
    }

    @Test
    void testBuscarItemPorIdCategoriaWithNonNullReturn() {
        Integer idCategoria = 1;
        List<Item> items = new ArrayList<>();
        items.add(new Item());
        when(itemUseCase.buscarItensPorIdCategoria(anyInt())).thenReturn(items);
        List<ItemResponse> result = itemService.buscarItemPorIdCategoria(idCategoria);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(itemUseCase, times(1)).buscarItensPorIdCategoria(anyInt());
    }

    @Test
    void testBuscarItemPorIdWithNonNullReturn() {
        Long idItem = 1L;
        Item item = new Item();
        when(itemUseCase.buscarItemPorId(anyLong())).thenReturn(item);
        ItemResponse result = itemService.buscarItemPorId(idItem);
        assertNotNull(result);
        verify(itemUseCase, times(1)).buscarItemPorId(anyLong());
    }

    @Test
    void testBuscarItemPorNomeCategoriaWithNonNullReturn() {
        String nomeCategoria = "Test";
        List<Item> items = new ArrayList<>();
        items.add(new Item());
        when(itemUseCase.buscarItemPorNomeCategoria(anyString())).thenReturn(items);
        List<ItemResponse> result = itemService.buscarItemPorNomeCategoria(nomeCategoria);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(itemUseCase, times(1)).buscarItemPorNomeCategoria(anyString());
    }
}